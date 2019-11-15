package Classes;

import Store.StudentGroups;

import java.util.List;
import java.util.Objects;

public class StudentGroup {

    //each group contains 8-10 students

    private final String name;
    private List<Student> studentList;

    public StudentGroup(String name, List<Student> studentList) {
        this.name = name;
        this.studentList = studentList;
        StudentGroups.add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentGroup)) return false;
        StudentGroup that = (StudentGroup) o;
        return name.equals(that.name) &&
                studentList.equals(that.studentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, studentList);
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    @Override
    public String toString() {
        return name + " " + getStudentList()+ "\n";
    }
}
