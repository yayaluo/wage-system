# wage-system

Design a salary calculation system

A company has three types of employees, and different types of employees have different ways of calculating wages, as follows. 
Besides, the employee will get extra 100 RMB during her/his birthday month.

1. For employees with a fixed salary, the monthly fixed salary is 6,000 RMB.
2. For hourly work model employees, with an hourly salary of 35 RMB and 160 work hours per month. The excess part is paid at 1.3 times.
3. For sales staff, the basic salary is 3000 per month, and the monthly basic sales should be 20000 RMB. If the sales are 20000 ~ 30000 RMB, the commission rate for the excess part (beyond 20,000 RMB) is 5%. 
   If the sales is 30,000 RMB and above, the commission rate for the excess part (beyond 20,000 RMB) is 8%.


## Usage

1. Run
```
java -jar target/wage-system.jar
```

2. Test result
```
Should pay the total wage：31032.10
```