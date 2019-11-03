package eu.glowacki.utp.assignment02.employee;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public abstract class Person {

	// To implement an attribute means that you provide a backing field and
	// getter or optionally setter for read-write properties/attributes
	// 
	// NO BACKING FIELDS SHOULD BE PROVIDED FOR DERIVED ATTRIBUTES
	// THOSE SHOULD BE COMPUTED ON-LINE
	//
	// attributes:
	// * first name (read-only)
	// * surname (read-only)
	// * birth date (read-only) --- date MUST BE represented by an instance of
	// type designed for date representation (either Date or LocalDate)
	//
	// * age (derived --- computed based on birth date) --- implemented as a
	// getter calculating the difference between the current date and birth date

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
}