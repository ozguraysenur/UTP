package eu.glowacki.utp.assignment02.employee;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Worker extends Employee {

	// attributes
	// * employment date
	// * bonus
	private LocalDate empdate;
	private BigDecimal bonus;
	
	public Worker(String firstName, String surname, LocalDate birthday, BigDecimal sal,Manager man,LocalDate _empdate,BigDecimal _bonus) {
		super(firstName,surname,birthday,sal,man);
		empdate=_empdate;
		bonus=_bonus;
	}
	public LocalDate getEmpdate() {
		return empdate;
	}

	@Override
	public int seniority() {

		return (int)empdate.until(LocalDate.now(), ChronoUnit.YEARS);
	}

	@Override
	public BigDecimal bonus() {
		return bonus;
	}


//	public Worker(String firstName, String surname, LocalDate birthday, BigDecimal sal,LocalDate _empdate,BigDecimal _bonus) {
//		super(firstName,surname,birthday,sal);
//		empdate=_empdate;
//		bonus=_bonus;
//	}
//	public Worker(String firstName, String surname, LocalDate birthday, BigDecimal sal,LocalDate _empdate) {
//		super(firstName,surname,birthday,sal);
//		empdate=_empdate;
//
//	}

}