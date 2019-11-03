package eu.glowacki.utp.assignment02.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Trainee extends Employee {

	// attributes:
	// * practice start date
	// * practice length (in days)
	private LocalDate startdate;
	private int practiseday;
	
	public Trainee(String firstName,String surname, LocalDate birthday, BigDecimal sal, Manager man,LocalDate start) {
		super(firstName,surname,birthday,sal,man);
		startdate=start;
		practiseday=(int)startdate.until(LocalDate.now(), ChronoUnit.YEARS);


	}
	public LocalDate getStartdate() {
		return startdate;
	}

	@Override
	public int seniority() {
		return practiseday;
	}

	@Override
	public BigDecimal bonus() {
		return new BigDecimal("0");
	}
}