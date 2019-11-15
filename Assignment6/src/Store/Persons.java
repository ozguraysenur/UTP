package Store;

import Classes.Person;

import java.util.*;

public class Persons {
    private static Set<Person> insan = new HashSet<>();
    private static List<Person> persons = new ArrayList<>(insan);
    private static final Random random =new Random();

    public static void add(Person p){
        persons.add(p);
        Collections.sort(persons);

    }
    public static List<Person> getPersons() {
        return persons;
    }
    public static Person Random() {
        int index =random.nextInt(persons.size()); //list size our range
        return persons.get(index);
    }

}
