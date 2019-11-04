package eu.glowacki.utp.assignment03.employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Employee extends Person {

	// (assignment 02)
	// attributes:
	// * salary
	// * manager (empty if at top of hierarchy)
    private BigDecimal salary;
    private Manager manager;

    protected Employee(String firstName, String surname, LocalDate birthday,String sal,Manager man) {

        super(firstName,surname,birthday);
        salary=new BigDecimal(sal);
        manager=man;
    }
    protected Employee(String firstName, String surname, LocalDate birthday,String sal) {

        super(firstName,surname,birthday);
        salary=new BigDecimal(sal);
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }
    public Manager getManager() {
        return manager;
    }
    public abstract int seniority();
    public abstract BigDecimal bonus();
    public abstract int seniorityMonth();

	// (assignment 03)
	// methods:
	// * salary is greater than given amount of money
	// * salary is less than given amount of money
	// * compare salary with other employee salary

    public int greater(double salary){
        if(this.getSalary().compareTo(new BigDecimal(salary))==1){
            return 1;
        }else if  (this.getSalary().compareTo(new BigDecimal(salary))== -1){
            return -1;
        }else return 0;
    }
    public int compare(Employee e){
        if(this.getSalary().compareTo(e.getSalary())==-1){
            return 1;
        }else if(this.getSalary().compareTo(e.getSalary())==1){
            return -1;
        }
        else return 0;

    }
    public int less(double salary){
        if(this.getSalary().compareTo(new BigDecimal(salary))==1){
            return -1;
        }else if  (this.getSalary().compareTo(new BigDecimal(salary))== -1){
            return 1;
        }else return 0;
    }






}