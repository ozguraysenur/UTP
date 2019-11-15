package Classes;

import Store.Teachers;

import java.util.Date;
import java.util.Objects;

public class Teacher extends Person implements Comparable<Person> {

    private final Degree degree;
    private final Date hiredate;
    public Teacher(String pesel, String surname, String name, Date birthday, Nationality nationality, Degree degree, Date hiredate) {
        super(pesel, surname, name, birthday, nationality);
        this.degree = degree;
        this.hiredate = hiredate;
        Teachers.add(this);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return degree == teacher.degree &&
                hiredate.equals(teacher.hiredate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), degree, hiredate);
    }

    @Override
    public int compareTo(Person o) {
        return super.compareTo(o);
    }

    public Degree getDegree() {
        return degree;
    }

    public Date getHiredate() {
        return hiredate;
    }

    @Override
    public String toString() {
        return super.toString() + degree +" " + hiredate + "\n";
    }
}

