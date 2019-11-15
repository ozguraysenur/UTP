package Classes;

import Store.Students;

import java.util.Date;
import java.util.Objects;

public class Student extends Person implements Comparable<Person>{

    private final String bookno;
    public Student(String pesel, String surname, String name, Date birthday, Nationality nationality, String bookno) {
        super(pesel, surname, name, birthday, nationality);
        this.bookno = bookno;
        Students.add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return bookno.equals(student.bookno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bookno);
    }

    @Override
    public int compareTo(Person o) {
        return super.compareTo(o);
    }

    public String getBookno() {
        return bookno;
    }

    @Override
    public String toString() {
        return super.toString() +" " + getNationality()+ " " +getBookno() + " \n " ;
    }
}
