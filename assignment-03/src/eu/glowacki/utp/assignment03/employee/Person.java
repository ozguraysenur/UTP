package eu.glowacki.utp.assignment03.employee;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Person {

	// (assignment 02)
	// attributes:
	// * first name
	// * surname
	// * birth date
	// * age (derived --- computed based on birth date)
    private final String _firstName; // backing field
    private final String _surname;
    private final LocalDate _birthday;

    protected Person(String firstName, String surname, LocalDate birthday) {
        _firstName = firstName;
        _surname=surname;
        _birthday=birthday;
    }

    public String getFirstName() { // getter
        return _firstName;
    }
    public String get_surname() {
        return _surname;
    }

    public LocalDate get_birthday() {
        return _birthday;
    }
    public int getAge() {
        int age= (int)_birthday.until(LocalDate.now(), ChronoUnit.YEARS);

        return age;
    }
	
	// (assignment 03)
	// methods:
	// * is older than other person
	// * is younger than other person
	// * compare age with other person's age

    public boolean olderthan(Person p){
        return compare(p) > 0;
    }
    public boolean youngerThan(Person p){
        return compare(p) < 0;
    }
    public int compare(Person p){
        return getAge() - p.getAge();
    }

}