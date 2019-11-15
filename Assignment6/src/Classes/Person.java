package Classes;

import Store.Persons;

import java.text.Collator;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public abstract class Person implements Comparable<Person> {
    static final Collator pl =Collator.getInstance(new Locale("pl"));
    //implementation of comparator which takes into account char ordering rules for given language.

    private final String pesel;
    private final String surname;
    private final String name;
    private final Date birthday;
    private final Nationality nationality;

    public Person(String pesel, String surname, String name, Date birthday, Nationality nationality) {
        this.pesel = pesel;
        this.surname = surname;
        this.name = name;
        this.birthday = birthday;
        this.nationality=nationality;

        Persons.add(this);
    }
    @Override
    public int compareTo(Person o) {
        int res= pl.compare(surname,o.surname);// icinde zaten compare var.
        if(res != 0){
            return res;
        }
        return pl.compare(name,o.name);


    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return pesel.equals(person.pesel) &&
                surname.equals(person.surname) &&
                name.equals(person.name) &&
                birthday.equals(person.birthday) &&
                nationality == person.nationality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesel, surname, name, birthday, nationality);
    }

    public String getPesel() {
        return pesel;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }
    public Nationality getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return pesel + " "+ name + " "+ surname +" "+ birthday ;
    }
}

