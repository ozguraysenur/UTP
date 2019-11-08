package eu.glowacki.utp.assignment04.test;

import eu.glowacki.utp.assignment04.InputParser;
import eu.glowacki.utp.assignment04.Person;
import eu.glowacki.utp.assignment04.PersonDatabase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class PersonDatabaseTest {

    File file;
    PersonDatabase data;

    @Before
    public void before(){
        file =new File("C:\\Users\\aysen\\Desktop\\assignment-04\\src\\Persons.txt");
        List<Person> list = InputParser.parse(file);
        data =new PersonDatabase(list);
    }
    @Test
    public void sortedByFirstName(){
        List<Person> fname= data.sortedByFirstName();
        Assert.assertEquals(6,fname.size());
        Assert.assertEquals(fname.get(0).get_firstName(),"Aysenur");
        System.out.println(fname);
    }
    @Test
    public void sortedBySurnameFirstNameAndBirthdate(){
        List<Person> every = data.sortedBySurnameFirstNameAndBirthdate();
        Assert.assertEquals(every.get(0).get_firstName(),"Zehra");
        Assert.assertEquals(6,every.size());
        System.out.println(every);
    }
    @Test
    public void sortedByBirthdate(){
        List<Person> birthdate= data.sortedByBirthdate();
        Assert.assertEquals(6,birthdate.size());
        Assert.assertEquals(birthdate.get(0).get_firstName(),"Mark");
        System.out.println(birthdate);
    }
    @Test
    public void bornOnDay(){
        List<Person> sameday= data.bornOnDay(dateFormat("1998-10-06"));
        Assert.assertEquals(2,sameday.size());
        //Assert.assertEquals(sameday.get(0).get_firstName(),"Bilal");
        System.out.println(sameday);
    }


    static Date dateFormat(String s){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(s);
        } catch (ParseException e) {
            System.out.println("Err in date");
            return  null;
        }

    }



}