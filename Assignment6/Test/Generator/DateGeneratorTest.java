package Generator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateGeneratorTest {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    //String dateString = format.format( new Date() );

    private static final String birthday = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
    private static final Pattern birth=Pattern.compile(birthday);

    @Test
    public void birthday() throws ParseException {
        Date date = DateGenerator.birthday();
        String strDate = format.format(date);
        Matcher matcher=birth.matcher(strDate);
        Assert.assertTrue(matcher.matches());

    }
}