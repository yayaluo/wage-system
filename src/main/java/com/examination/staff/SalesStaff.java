package src.main.java.com.examination.staff;

import src.main.java.com.examination.strategy.StaffSalaryStrategy;

public class SalesStaff extends RegularStaff implements StaffSalaryStrategy {

    private static final double SALEROOM_BASE = 20000;
    private static final double SALEROOM_MID = 30000;
    private static final double SALARY_SALE_BASE = 3000;

    public SalesStaff() {
    }

    public SalesStaff(double baseSalesSalary, double lowPercent, double middlePercent) {

        this.baseSalesSalary = baseSalesSalary;
        this.lowPercent = lowPercent;
        this.middlePercent = middlePercent;
    }

    @Override
    public double calcSalary(RegularStaff staff) {

        double result = 0;
        if (staff.baseSalesSalary <= SALEROOM_BASE) {
            result = SALARY_SALE_BASE;
        }

        if (staff.baseSalesSalary > SALEROOM_BASE && staff.baseSalesSalary <= SALEROOM_MID) {
            result = SALARY_SALE_BASE + (staff.baseSalesSalary - SALEROOM_BASE) * staff.lowPercent;
        }

        if (staff.baseSalesSalary > SALEROOM_MID) {
            result = SALARY_SALE_BASE + (staff.baseSalesSalary - SALEROOM_BASE) * staff.middlePercent;
        }

        return result;
    }
}
