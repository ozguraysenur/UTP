package Store;

import Classes.Department;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Departments {
    private static Set<Department> dep =new HashSet<>();
    private static List<Department> bolum =new ArrayList<>(dep);

    public static void add(Department department){
        bolum.add(department);
    }
    public static List<Department> getBolum() {
        return bolum;
    }
}
