package eu.glowacki.utp.assignment02.employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Employee extends Person {

	//
	// attributes:
	// * salary (use BigDecimal type for representing currency values)
	// * manager (empty if at top of hierarchy)

	private BigDecimal salary;
	private Manager manager;

	protected Employee(String firstName, String surname, LocalDate birthday,BigDecimal sal,Manager man) {

		super(firstName,surname,birthday);
		salary=sal;
		manager=man;
	}
	protected Employee(String firstName, String surname, LocalDate birthday,BigDecimal sal) {

		super(firstName,surname,birthday);
		salary=sal;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public Manager getManager() {
		return manager;
	}
	public abstract int seniority();
	public abstract BigDecimal bonus();
}