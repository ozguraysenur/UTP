package Generator;

import Classes.Student;
import Store.Students;

import java.util.Random;

public class StudentGenerator {
    private static final Random random =new Random();
    public static Student Random() {
        int index =random.nextInt(Students.getOgrenci().size()); //list size our range
        return Students.getOgrenci().get(index);
    }
}
