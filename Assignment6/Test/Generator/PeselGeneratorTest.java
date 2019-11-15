package Generator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class PeselGeneratorTest {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String pesel;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void generator() throws ParseException {
        String dateString = format.format(new Date());
        Date  date = format.parse( "1888-3-31" );

        pesel= PeselGenerator.generate(date);
        System.out.println(pesel);
        Assert.assertEquals(11,pesel.length());
        Assert.assertTrue(pesel.startsWith("888331"));

    }

    @Test
    public void getSex() {
        Assert.assertEquals("women",PeselGenerator.getSex("88833128522"));

    }
}