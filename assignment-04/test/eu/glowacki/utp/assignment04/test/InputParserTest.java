package eu.glowacki.utp.assignment04.test;

import eu.glowacki.utp.assignment04.InputParser;
import eu.glowacki.utp.assignment04.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

public final class InputParserTest {

    File file;
    @Before
    public void before(){
        file =new File("C:\\Users\\aysen\\Desktop\\assignment-04\\src\\Persons.txt");
    }

    @Test
    public void parse(){
        List<Person> persons = InputParser.parse(file);
        Assert.assertTrue(file.exists());
        Assert.assertEquals(140,file.length());
        Assert.assertNotNull(persons);
        Assert.assertEquals(6,persons.size());
    }

}