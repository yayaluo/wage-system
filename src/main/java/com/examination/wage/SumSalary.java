package src.main.java.com.examination.wage;

import java.util.Calendar;
import java.util.List;

import src.main.java.com.examination.staff.CommonStaff;
import src.main.java.com.examination.staff.Staff;
import src.main.java.com.examination.staff.HourlyStaff;
import src.main.java.com.examination.staff.SalesStaff;
import src.main.java.com.examination.strategy.StaffSalaryStrategy;

public class SumSalary {

    private static final double SALARY_BASE = 6000;
    private static final double SALARY_HOUR = 35;
    private static final double PERCENT_LOW = 0.05;
    private static final double PERCENT_MIDDLE = 0.08;
    private static final double AWARD_BIRTH = 100;

    public static double get(double sumSalary, List<Staff> staff, int month) {

        for (Staff s : staff) {
            switch (s.getType()) {
                case "salary":
                    StaffSalaryStrategy staffSalaryStrategy = new CommonStaff();
                    if (s.getBirthday().get(Calendar.MONTH) == month) {

                        BirthdaySalary birthdaySalary = new BirthdaySalary(staffSalaryStrategy);
                        sumSalary = sumSalary + birthdaySalary.calcBirthdaySalary(new CommonStaff(SALARY_BASE), AWARD_BIRTH);
                    } else {

                        Salary salary = new Salary(staffSalaryStrategy);
                        sumSalary += salary.calcSalary(new CommonStaff(SALARY_BASE));
                    }
                    break;
                case "hour":
                    StaffSalaryStrategy hourStaff = new HourlyStaff();
                    if (s.getBirthday().get(Calendar.MONTH) == month) {
                        BirthdaySalary birthdayHourSalary = new BirthdaySalary(hourStaff);
                        sumSalary += birthdayHourSalary.calcBirthdaySalary(new HourlyStaff(SALARY_HOUR, s.getWorkingHours()), AWARD_BIRTH);
                    } else {
                        Salary hourSalary = new Salary(hourStaff);
                        sumSalary += hourSalary.calcSalary(new HourlyStaff(SALARY_HOUR, s.getWorkingHours()));
                    }
                    break;
                case "sale":
                    StaffSalaryStrategy salesStaff = new SalesStaff();
                    if (s.getBirthday().get(Calendar.MONTH) == month) {
                        BirthdaySalary birthdaySalesSalary = new BirthdaySalary(salesStaff);
                        sumSalary += birthdaySalesSalary.calcBirthdaySalary(new SalesStaff(s.getAmount(), PERCENT_LOW, PERCENT_MIDDLE), AWARD_BIRTH);
                    } else {
                        Salary salarySales = new Salary(salesStaff);
                        sumSalary += salarySales.calcSalary(new SalesStaff(s.getAmount(), PERCENT_LOW, PERCENT_MIDDLE));

                    }
                    break;
            }
        }

        return sumSalary;
    }
}
