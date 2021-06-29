package src.main.java.com.examination.wage;

import src.main.java.com.examination.staff.RegularStaff;
import src.main.java.com.examination.strategy.StaffSalaryStrategy;

public class BirthdaySalary extends Salary {

    public BirthdaySalary(StaffSalaryStrategy staffSalaryStrategy) {
        super(staffSalaryStrategy);
    }

    public double calcBirthdaySalary(RegularStaff regularStaff, double birthAward) {
        return super.calcSalary(regularStaff) + birthAward;
    }
}
