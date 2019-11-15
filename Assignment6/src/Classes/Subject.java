package Classes;

import Store.Subjects;

import java.util.List;
import java.util.Objects;

public class Subject {
    private final String name;
    private final Department supervisorD ;
    private final Teacher lecturer;
    private List<Student> attendance;


    public Subject(String name, Department supervisorD, Teacher lecturer, List<Student> attendance) {
        this.name = name;
        this.supervisorD = supervisorD;
        this.lecturer = lecturer;
        this.attendance = attendance;
        Subjects.add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject)) return false;
        Subject subject = (Subject) o;
        return name.equals(subject.name) &&
                supervisorD.equals(subject.supervisorD) &&
                lecturer.equals(subject.lecturer) &&
                attendance.equals(subject.attendance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, supervisorD, lecturer, attendance);
    }

    public String getName() {
        return name;
    }

    public Department getSupervisorD() {
        return supervisorD;
    }

    public Teacher getLecturer() {
        return lecturer;
    }

    public List<Student> getAttendance() {
        return attendance;
    }

    @Override
    public String toString() {
        return name + "\n " + supervisorD + " " + lecturer + " " + getAttendance() + "\n ";
    }
}
