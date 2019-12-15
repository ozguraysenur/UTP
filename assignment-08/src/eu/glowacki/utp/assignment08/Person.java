package eu.glowacki.utp.assignment08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Date;

public class Person implements Comparable<Person> {

	private final String _firstName;
	private final String _surname;
	private final Date _birthdate;

	public Person(String firstName, String surname, Date birthdate) {
		_firstName = firstName;
		_surname = surname;
		_birthdate = birthdate;
	}

	// assignment 8
	public void serialize(DataOutputStream output) throws Assignment08Exception {
		// serialize birth date with getTime() method
		// encapsulate IOException in Assignment08Exception
		try {
			output.writeUTF(_firstName);
			output.writeUTF(_surname);
			output.writeLong(_birthdate.getTime());

		} catch (Throwable e) {
			throw new Assignment08Exception("ups some problems occured in serialization..." ,e);
		}
	}
	
	public static Person deserialize(DataInputStream input) throws Assignment08Exception {
		try {
			String name= input.readUTF();
			String surname= input.readUTF();
			Date birth =new Date(input.readLong());
			return new Person(name,surname,birth);
		} catch (Throwable e) {
			throw new Assignment08Exception("ups some problems occured in deserialization...",e);
		}
	}

	@Override
	public int compareTo(Person o) {
		int res= this.getSurname().compareTo(o.getSurname());
		if(res != 0){
			return res;
		}else{
			res = this.getFirstName().compareTo(o.getFirstName());
			if(res != 0 ){
				return res;
			}else{
				return this.getBirthDate().compareTo(o.getBirthDate());
			}
		}
	}

	public String getFirstName() {
		return _firstName;
	}

	public String getSurname() {
		return _surname;
	}

	public Date getBirthDate() {
		return _birthdate;
	}
	@Override
	public String toString() {
		return _firstName + " " + _surname + " " + _birthdate + "\n" ;

	}
}