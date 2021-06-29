package src.main.java.com.examination.staff;

import java.util.Calendar;

public class Staff {

    private String name;

    private String type;

    private double workHours;

    private Calendar birthday;

    private double amount;

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWorkingHours() {
        return workHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workHours = workingHours;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
