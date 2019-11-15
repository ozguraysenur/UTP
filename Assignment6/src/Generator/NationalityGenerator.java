package Generator;

import Classes.Nationality;

import java.util.Random;

public class NationalityGenerator {
    static Random random =new Random();
    private static Nationality[] nationalities =Nationality.values();
    public static Nationality randomNationality(){
        int index = random.nextInt(nationalities.length);
        return nationalities[index];
    }
}
