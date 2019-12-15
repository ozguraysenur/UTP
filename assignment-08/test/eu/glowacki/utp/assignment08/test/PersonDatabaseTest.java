package eu.glowacki.utp.assignment08.test;
import eu.glowacki.utp.assignment08.Assignment08Exception;
import eu.glowacki.utp.assignment08.InputParser;
import eu.glowacki.utp.assignment08.Person;
import eu.glowacki.utp.assignment08.PersonDatabase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.List;


public class PersonDatabaseTest {

	File file;
	PersonDatabase data;
	File binary;

	@Before  public void before(){
		file =new File("C:\\Users\\aysen\\IdeaProjects\\assignment-08\\src\\Persons.txt");
		binary=new File("C:\\Users\\aysen\\IdeaProjects\\assignment-08\\src\\output.dat");
		List<Person> list = InputParser.parse(file);
		data =new PersonDatabase(list);
	}

	@Test
	public void serializeAndDeserialize() throws Throwable {

		//serialization
			OutputStream output=new FileOutputStream(binary);
			DataOutputStream dataOutputStream=new DataOutputStream(output);
			data.serialize(dataOutputStream);
			dataOutputStream.close();
		//deserialization
			InputStream input =new FileInputStream(binary);
			DataInputStream dataInputStream=new DataInputStream(input);
			PersonDatabase deser=PersonDatabase.deserialize(dataInputStream);
			dataInputStream.close();
		Assert.assertNotNull(deser);
		Assert.assertEquals(data.size(),deser.size());



	}
}