package src.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Attribute;
import org.jdom2.DataConversionException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import src.main.java.com.examination.staff.Staff;
import src.main.java.com.examination.wage.SumSalary;


public class CalSalaryTest {

    public static void main(String[] args) {

        Map<Integer, List<Staff>> map = new HashMap<>();
        SAXBuilder saxBuilder = new SAXBuilder();
        InputStream input = null;
        try {
            input = new FileInputStream(new File("src/resources/salary.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Document document = null;
        try {
            document = saxBuilder.build(input);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Element root = document.getRootElement();
        List<Element> children = root.getChildren();
        for (Element child : children) {
            List<Attribute> attributes = child.getAttributes();
            Integer key = 0;
            for (Attribute attr : attributes) {
                try {
                    key = attr.getIntValue();
                } catch (DataConversionException e) {
                    e.printStackTrace();
                }
            }

            List<Staff> staffs = new ArrayList<>();
            List<Element> childList = child.getChildren();
            for (Element el : childList) {
                List<Attribute> elAttr = el.getAttributes();
                Staff staff = new Staff();
                for (Attribute attr : elAttr) {
                    try {
                        switch (attr.getName()) {
                            case "name":
                                staff.setName(attr.getValue());
                                break;
                            case "type":
                                staff.setType(attr.getValue());
                                break;
                            case "birthday":
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                Calendar cal = Calendar.getInstance();
                                try {
                                    cal.setTime(sdf.parse(attr.getValue()));
                                    staff.setBirthday(cal);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case "workingHours":
                                staff.setWorkingHours(attr.getDoubleValue());
                                break;
                            case "amount":
                                staff.setAmount(attr.getDoubleValue());
                                break;
                        }
                    } catch (DataConversionException ex) {
                        ex.printStackTrace();
                    }
                }

                staffs.add(staff);
            }

            map.put(key, staffs);
        }

        if (null != input) {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        double sum = 0;
        for (Map.Entry<Integer, List<Staff>> entry : map.entrySet()) {

            if (9 == entry.getKey() || 10 == entry.getKey()) {
                sum = SumSalary.get(sum, entry.getValue(), entry.getKey());
            }
        }

        DecimalFormat format = new DecimalFormat("#.00");
        System.out.println("Should pay the total wage：" + format.format(sum));
    }

}
