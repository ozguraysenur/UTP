package Store;
import Classes.Nationality;
import Classes.Student;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class Students {
    //private static Set<Student> ogrenci =new TreeSet<>();
    private static Set<Student> stu = new HashSet<>();
    private static List <Student> ogrenci =new ArrayList<>(stu);


    public static void add(Student student){
        ogrenci.add(student);
        Collections.sort(ogrenci);

    }

    public static List<Student> getOgrenci() {
        return ogrenci;
    }



    public List<Student> filtering(Nationality nationality) {
        Locale temp = new Locale(nationality.getLoc().getLanguage());
        List<Student> sortt = new ArrayList<>();
        return sortt
                .stream()
                .filter(e -> e.getNationality().getLoc() == nationality.getLoc())
                .collect(Collectors.toList());
    }

    public void sorting(Nationality nationality) {
        List<Student> filtered = filtering(nationality);
        Collator coll = Collator.getInstance(new Locale(nationality.getLoc().getLanguage(), nationality.getLoc().getCountry()));
        Collections.sort(filtered,coll);
    }


}
