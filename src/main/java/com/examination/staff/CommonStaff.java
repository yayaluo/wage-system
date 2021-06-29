package src.main.java.com.examination.staff;

import src.main.java.com.examination.strategy.StaffSalaryStrategy;


public class CommonStaff extends RegularStaff implements StaffSalaryStrategy {

    public CommonStaff() {

    }

    public CommonStaff(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public double calcSalary(RegularStaff staff) {
        return staff.baseSalary;
    }

}
