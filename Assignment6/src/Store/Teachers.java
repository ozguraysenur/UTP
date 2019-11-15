package Store;

import Classes.Teacher;

import java.util.*;

public class Teachers {
    private static Set<Teacher> h = new HashSet<>();
    private static List<Teacher> hoca = new ArrayList<>(h);
    private static final Random random =new Random();

    public static void add(Teacher teacher){
        hoca.add(teacher);
        Collections.sort(hoca);
    }
    public static List<Teacher> getHoca() {
        return hoca;
    }
    public static Teacher Random() {
        int index =random.nextInt(hoca.size()); //list size our range
        return hoca.get(index);
    }
}
