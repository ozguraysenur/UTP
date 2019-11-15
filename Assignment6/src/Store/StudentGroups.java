package Store;

import Classes.StudentGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentGroups {
    private static Set<StudentGroup> h =new HashSet<>();
    private static List<StudentGroup> grup =new ArrayList<>(h);

    public static void add(StudentGroup group){
        grup.add(group);

    }
    public static List<StudentGroup> getStudentGroups() {
        return grup;
    }
}
