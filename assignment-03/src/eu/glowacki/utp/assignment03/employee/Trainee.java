package eu.glowacki.utp.assignment03.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Trainee extends Employee {


	// (assignment 02)
	// attributes:
	// * practice start date
	// * practice length (in days)

    private LocalDate startdate;
    private int practiseday;

    public Trainee(String firstName, String surname, LocalDate birthday, String sal, Manager man, LocalDate start) {
        super(firstName,surname,birthday,sal,man);
        startdate=start;
        practiseday=(int)startdate.until(LocalDate.now(), ChronoUnit.DAYS);


    }
    public LocalDate getStartdate() {
        return startdate;
    }

    @Override
    public int seniority() {
        return (int)startdate.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    @Override
    public int seniorityMonth() {
        return (int)startdate.until(LocalDate.now(), ChronoUnit.MONTHS);
    }


    @Override
    public BigDecimal bonus() {
        return new BigDecimal("0");
    }

	
	// (assignment 03)
	// * practice length is shorter than given number of days
	// * practice length is longer than given number of days

    public int Shorter(int days){
        if(practiseday<days){
            return 1;
        }else if(practiseday>days){
            return -1;
        }else return 0;

    }
    public int Longer(int days){
        if(practiseday<days){
            return -1;
        }else if(practiseday>days){
            return  1;
        }else return 0;

    }

}