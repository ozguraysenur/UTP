package eu.glowacki.utp.assignment04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Comparable<Person> {
	
	private final String _firstName;
	private final String _surname;
	private final Date _birthdate;
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public Person(String firstName, String surname, Date birthdate) {
		_firstName = firstName;
		_surname = surname;
		_birthdate = birthdate;
	}
	@Override
	public int compareTo(Person otherPerson) {
		int res= this.get_surname().compareTo(otherPerson.get_surname());
		if(res != 0){
			return res;
		}else{
			res = this.get_firstName().compareTo(otherPerson.get_firstName());
			if(res != 0 ){
				return res;
			}else{
				return this.get_birthdate().compareTo(otherPerson.get_birthdate());
			}
		}
	}

	//natural order >> surname > firstname > birth

	public String get_firstName() {
		return _firstName;
	}

	public String get_surname() {
		return _surname;
	}

	public Date get_birthdate() {
		return _birthdate;
	}

	@Override
	public String toString() {
		return _firstName + " " + _surname + " " + _birthdate + "\n" ;

	}
}