package eu.glowacki.utp.assignment04;

import eu.glowacki.utp.assignment04.comparators.BirthdateComparator;
import eu.glowacki.utp.assignment04.comparators.FirstNameComparator;

import java.util.*;
import java.util.stream.Collectors;

public final class PersonDatabase {
	private List<Person> byname;
	private List<Person> surnamefirstnamebirthday;
	private List<Person> bybirthday;
	private Map<Date,List<Person>> quick=new TreeMap<>();
	private Comparator<Person> snamefnamebirth= Comparator.naturalOrder();

	public PersonDatabase(List<Person> person) {
		byname = person;
		surnamefirstnamebirthday = person;
		bybirthday = person;
		quick = person
				.stream()
				.collect(Collectors.groupingBy(Person::get_birthdate,Collectors.toList()));
	}

	public List<Person> sortedByFirstName() {
		Collections.sort(byname,new FirstNameComparator());
		return byname;

	}
	
	public List<Person> sortedBySurnameFirstNameAndBirthdate() {
		Collections.sort(surnamefirstnamebirthday, snamefnamebirth);
		return surnamefirstnamebirthday;
	}
	
	public List<Person> sortedByBirthdate() {
		Collections.sort(bybirthday,new BirthdateComparator());
		return bybirthday;
	}
	
	public List<Person> bornOnDay(Date date) {
		return quick.get(date);
	}
}