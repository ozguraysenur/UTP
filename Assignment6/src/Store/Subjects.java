package Store;

import Classes.Subject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subjects {
    private static Set<Subject> d =new HashSet<>();
    private static List<Subject> ders =new ArrayList<>(d);

    public static void add(Subject subject){
        ders.add(subject);

    }
    public static List<Subject> getDers() {
        return ders;
    }
}
