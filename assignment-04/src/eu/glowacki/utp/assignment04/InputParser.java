package eu.glowacki.utp.assignment04;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InputParser {


	// 1. Use regular expresssions (Pattern) for validating input data
	//    U¿yæ regularnych wyra¿eñ (Pattern) do walidacji danych wejœciowych
	//
	// 2. Convert input string representing date using SimpleDateFormat "yyyy-MM-dd" 
	//    Konwersjê wejœciowego ci¹gu znaków reprezentuj¹cego datê nale¿y oprzeæ np. DateFormat 
	//    SimpleDateFormat format "yyyy-MM-dd"

	private static final String name = "([A-Z][a-z]+)";
	private static final String surname = "([A-Z][a-z]+)";
	private static final String birthday = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
	private static final String whitespace = "(?:[ \t]+)";
	private static final String merge = name + whitespace + surname + whitespace + birthday;
	private static final Pattern mergePat=Pattern.compile(merge);

	public static List<Person> parse(File file) {
		List <Person> person =new ArrayList<>();
		try {
			BufferedReader reader =new BufferedReader(new FileReader(file));
			String line ;
			while ((line=reader.readLine()) !=  null){
				Matcher matcher=mergePat.matcher(line);
				if(!matcher.matches()){
					return null;
				}else{
					String firstname = matcher.group(1);
					//System.out.println(firstname);
					String lastname =matcher.group(2); //surname
					//System.out.println(lastname);
					Date birth =dateFormat(matcher);
					//System.out.println(birth);
					person.add(new Person(firstname,lastname,birth));

				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return person;
	}

	static Date dateFormat(Matcher m){

		String input =m.group(3); //birthday
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(input);
		} catch (ParseException e) {
			System.out.println("Err in date");
			return  null;
		}

	}
}