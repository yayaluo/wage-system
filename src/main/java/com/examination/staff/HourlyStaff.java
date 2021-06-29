package src.main.java.com.examination.staff;

import src.main.java.com.examination.strategy.StaffSalaryStrategy;

public class HourlyStaff extends RegularStaff implements StaffSalaryStrategy {

    private static final double MONTHLY_HOURS = 160;
    private static final double SALARY_PERCENT = 1.3;

    public HourlyStaff() {
    }

    public HourlyStaff(double hourSalary, double workHours) {
        this.hourSalary = hourSalary;
        this.workHours = workHours;
    }

    @Override
    public double calcSalary(RegularStaff staff) {

        double result = staff.workHours * staff.hourSalary;

        if (staff.workHours > MONTHLY_HOURS) {
            result = new Double(MONTHLY_HOURS * staff.hourSalary + (staff.workHours - MONTHLY_HOURS) * staff.hourSalary * SALARY_PERCENT);
        }

        return result;
    }

}
