package eu.glowacki.utp.assignment03.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Worker extends Employee {

	// (assignment 02)
	// attributes:
	// * employment date
	// * bonus
    private LocalDate empdate;
    private BigDecimal bonus;
    private boolean hasBonus = false;




    public Worker(String firstName, String surname, LocalDate birthday, String sal, Manager man, LocalDate _empdate, BigDecimal _bonus) {
        super(firstName,surname,birthday,sal,man);
        empdate=_empdate;
        bonus=_bonus;
        if(bonus != new BigDecimal("0")){
            hasBonus=true;
        }
    }
    public LocalDate getEmpdate() {
        return empdate;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    @Override
    public int seniority() {

        return (int)empdate.until(LocalDate.now(), ChronoUnit.YEARS);
    }
    @Override
    public int seniorityMonth() {
        return (int)empdate.until(LocalDate.now(), ChronoUnit.MONTHS);
    }

    @Override
    public BigDecimal bonus() {
        return bonus;
    }


    public boolean isHasBonus() {
        return hasBonus;
    }

    // (assignment 03)
	// attributes:
	// * has bonus
	//
	// methods:
	// * seniority is longer than given number of years (seniority - sta¿)
	// * seniority is longer than given number of months
	// * has bonus greater than given amount of money


    public int LongerYears(int years){
        if(seniority() > years){
            return 1;
        }else if(seniority()==years){
            return 0 ;
        }else return -1;
    }
    public int LongerMonth(int months){
        if(seniorityMonth() > months){
            return 1;
        }else if(seniorityMonth()==months){
            return 0 ;
        }else return -1;
    }
    public int bonusGreater(double num){
        return this.bonus().compareTo(new BigDecimal(num));
    }





}