package Generator;

import Classes.*;
import Store.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class GeneratorTest {
    private static final int studentnumber = 100;
    private static final int studentgroupnumber = 12;
    private static final int departmentnumber = 3;
    private static final int subjectnumber = 10;
    private static final int teachernumber = 10;
    Random random =new Random();
    @Test
    public void allTESTS(){
        generateStudent();
        generateTeachers();
        generateStudentGroup();
        generateDepartment();
        generateSubjects();

    }

    @Test
    public void generateStudent(){
        for (int i = 1; i <= studentnumber; i++) {
            String name ="studentname " + i ;
            String surname= "surname "+i;
            Date birth =DateGenerator.birthday();
            String pesel =PeselGenerator.generate(birth);
            Nationality nationality =NationalityGenerator.randomNationality();
            int notes =random.nextInt(100);
            String book =String.valueOf(notes);
            new Student(pesel,surname,name,birth,nationality,book);
        }
       // System.out.println(Students.getOgrenci());
        Assert.assertEquals(100,Students.getOgrenci().size());
    }
    @Test
    public void generateStudentGroup(){
        List<Student> students =new ArrayList<>();
       // generateStudent();

        char a ='A';
        for (int i = 1; i <= studentgroupnumber ; i++) {
            String groupname ="Group "+ a;
            for (int j = 0; j < 9; j++) {
                students.add(Students.getOgrenci().get(random.nextInt(Students.getOgrenci().size())));
            }
            new StudentGroup(groupname,students);
            //System.out.println(StudentGroups.getStudentGroups().get(i-1));
            a= (char)(a+1);
            students.clear();

        }
        Assert.assertEquals(12,StudentGroups.getStudentGroups().size());

    }
    @Test
    public void generateTeachers(){
        for (int i = 1; i <= teachernumber; i++) {
            String name ="teachername " + i ;
            String surname= "surname "+i;
            Date birth =DateGenerator.birthday();
            String pesel =PeselGenerator.generate(birth);
            Nationality nationality =NationalityGenerator.randomNationality();
            Degree degree =DegreeGenerator.randomDegree();
            Date hiredate =DateGenerator.hiredate();      //ya yasindan once ise baslamamissa
            new Teacher(pesel,surname,name,birth,nationality,degree,hiredate);
        }
         //System.out.println(Teachers.getHoca());
           Assert.assertEquals(10,Teachers.getHoca().size());

    }
    @Test
    public void generateDepartment(){
        List<Teacher> teachers =new ArrayList<>();
        //generateTeachers();
        char a ='A';
        for (int i = 1; i <= departmentnumber ; i++) {
            String depname ="Department "+ a;
            for (int j = 0; j < 3; j++) {
                teachers.add(Teachers.getHoca().get(random.nextInt(Teachers.getHoca().size())));
            }
            new Department(depname,teachers);
            //System.out.println(Departments.getBolum().get(i-1));
            a= (char)(a+1);
            teachers.clear();

        }

        Assert.assertEquals(3, Departments.getBolum().size());

    }
    @Test
    public void generateSubjects(){
        List<Student> attending =new ArrayList<>();
       //generateStudent();
       //generateDepartment();


        char a ='A';
        for (int i = 1; i <= subjectnumber ; i++) {
            String sub ="Subject : "+ a;
            int ona =random.nextInt(10);
            for (int j = 0; j < ona; j++) {
                attending.add(Students.getOgrenci().get(random.nextInt(Students.getOgrenci().size())));
            }
            Department k =Departments.getBolum().get(random.nextInt(Departments.getBolum().size()));
            //Teacher lecturer =k.getTeacherlist().get(random.nextInt(2));
            Teacher lecturer =Teachers.getHoca().get(random.nextInt(Teachers.getHoca().size()));
            new Subject(sub, k ,lecturer,attending);
            //System.out.println(Subjects.getDers().get(i-1));
            a= (char)(a+1);
            attending.clear();

        }
        Assert.assertEquals(subjectnumber, Subjects.getDers().size());

    }
}
