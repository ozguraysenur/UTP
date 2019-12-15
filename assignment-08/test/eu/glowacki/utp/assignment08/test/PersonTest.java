package eu.glowacki.utp.assignment08.test;

import eu.glowacki.utp.assignment08.Assignment08Exception;
import eu.glowacki.utp.assignment08.Person;
import eu.glowacki.utp.assignment08.PersonDatabase;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class PersonTest {

	File file =new File("C:\\Users\\aysen\\IdeaProjects\\assignment-08\\src\\bus.txt");
	String datt= "1997-10-29";
	Date date;

	{
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(datt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	Person person =new Person("Busra","Yilmaz",date );
	@Test
	public void serializeAndDeserialize()  {
		OutputStream output= null;
		try {
			//serialization

			output = new FileOutputStream(file);
			DataOutputStream dataOutputStream=new DataOutputStream(output);
			person.serialize(dataOutputStream);
			dataOutputStream.close();

			//deserialization

            InputStream input =new FileInputStream(file);
			DataInputStream dataInputStream=new DataInputStream(input);
			Person deser=Person.deserialize(dataInputStream);
			dataInputStream.close();

			Assert.assertNotNull(deser);
			Assert.assertEquals(person.getFirstName(),deser.getFirstName());
			System.out.println(deser.getFirstName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Assignment08Exception e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}