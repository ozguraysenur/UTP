package Classes;

import Generator.DateGenerator;
import Generator.PeselGenerator;
import Store.Departments;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Department{
    private final String name;
    private List<Teacher> teacherlist;

    public Department(String name, List<Teacher> teacherlist) {
        this.name = name;
        this.teacherlist = teacherlist;
        Departments.add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return name.equals(that.name) &&
                teacherlist.equals(that.teacherlist);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, teacherlist);
    }

    public String getName() {
        return name;
    }

    public List<Teacher> getTeacherlist() {
        return teacherlist;
    }


    @Override
    public String toString() {
        return name + "\n " +getTeacherlist() + "\n";
    }
}


