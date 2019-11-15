package Generator;

import Classes.Degree;

import java.util.Random;

public class DegreeGenerator {
    static Random random =new Random();
    private static Degree[] degrees =Degree.values();
    public static Degree randomDegree(){
        int index = random.nextInt(degrees.length);
        return degrees[index];
    }
}
