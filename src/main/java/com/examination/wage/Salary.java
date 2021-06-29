package src.main.java.com.examination.wage;

import src.main.java.com.examination.staff.RegularStaff;
import src.main.java.com.examination.strategy.StaffSalaryStrategy;

public class Salary {

    private StaffSalaryStrategy staffSalaryStrategy;

    public Salary(StaffSalaryStrategy staffSalaryStrategy) {

        this.staffSalaryStrategy = staffSalaryStrategy;
    }

    public double calcSalary(RegularStaff staff) {
        return this.staffSalaryStrategy.calcSalary(staff);
    }
}
