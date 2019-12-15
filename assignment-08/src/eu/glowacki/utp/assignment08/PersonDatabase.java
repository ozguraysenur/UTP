package eu.glowacki.utp.assignment08;

import eu.glowacki.utp.assignment08.comparators.BirthdateComparator;
import eu.glowacki.utp.assignment08.comparators.FirstNameComparator;
import org.omg.CORBA.PERSIST_STORE;
import sun.dc.path.PathError;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public final class PersonDatabase {
	private List<Person> byname;
	private List<Person> surnamefirstnamebirthday;
	private List<Person> bybirthday;
	private Comparator<Person> snamefnamebirth= Comparator.naturalOrder();
	private Map<Date,List<Person>> quick=new TreeMap<>();

	public PersonDatabase(List<Person> person) {
		byname = person;
		surnamefirstnamebirthday = person;
		bybirthday = person;
		quick = person
				.stream()
				.collect(Collectors.groupingBy(Person::getBirthDate,Collectors.toList()));
	}


	// assignment 8 - factory method based on deserialization
	public static PersonDatabase deserialize(DataInputStream input) throws Assignment08Exception {
		try {
			List <Person> persons =new ArrayList<>();
			int size= input.readInt();
			for (int i = 0; i < size; i++) {
				Person person= Person.deserialize(input);
				persons.add(person);
			}
			return new PersonDatabase(persons);
		} catch (Throwable e) {
			throw new Assignment08Exception("database deserialization error!",e);
		}
	}

	// assignment 8
	public void serialize(DataOutputStream output) throws Assignment08Exception {
		try {
			output.writeInt(surnamefirstnamebirthday.size());
			for (Person p : surnamefirstnamebirthday) {
				p.serialize(output);
			}
		} catch (Throwable e) {
			throw new Assignment08Exception("database serialization error!",e);
		}
	}

	// assignment 4
	public List<Person> sortedByFirstName() {
		Collections.sort(byname, new FirstNameComparator());
		return byname;
	}

	// assignment 4
	public List<Person> sortedBySurnameFirstNameAndBirthdate() {
		Collections.sort(surnamefirstnamebirthday, snamefnamebirth);
		return surnamefirstnamebirthday;
	}

	// assignment 4
	public List<Person> sortedByBirthdate() {
		Collections.sort(bybirthday,new BirthdateComparator());
		return bybirthday;
	}

	// assignment 4
	public List<Person> bornOnDay(Date date) {
		return quick.get(date);
	}
	public static void print(List<Person> list){
		for (Person p : list){
			System.out.println(p.getFirstName()+" "+p.getSurname()+" "+p.getBirthDate());
		}
	}

	public int size() {
		return surnamefirstnamebirthday.size();
	}
}