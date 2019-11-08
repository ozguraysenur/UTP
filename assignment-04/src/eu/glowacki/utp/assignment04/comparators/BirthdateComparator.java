package eu.glowacki.utp.assignment04.comparators;

import java.util.Comparator;

import eu.glowacki.utp.assignment04.Person;

public final class BirthdateComparator implements Comparator<Person> {

	@Override
	public int compare(Person person1, Person person2) {

		return person1.get_birthdate().compareTo(person2.get_birthdate());//if Date1 is after Date2 return 1

	}
}