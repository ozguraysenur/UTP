import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WeatherTest {

    private static final int DEGREE = 30;
    private Weather forecast;
   // List<Weather> weatherList = new ArrayList<>();


    @Before
    public void before() throws Exception {

       // weatherList.add(new Weather(30));
        forecast = new Weather(DEGREE);
        Assert.assertEquals(DEGREE, forecast.getDegree());
    }


    @Test
    public void aggregate() {
        int aggregate = forecast.aggregate(null);
        Assert.assertEquals(DEGREE, aggregate);
        final int init = 30;
        Assert.assertEquals((int) (DEGREE + init), (int) (forecast.aggregate(init)));
    }

    @Test
    public void deepClone() {
        Weather clone = forecast.deepClone();
        Assert.assertEquals(forecast.getDegree(), clone.getDegree());
        Assert.assertNotSame(forecast, clone);
    }

    @Test
    public void isSunny() {
        assertFalse(forecast.isSunny());
    }
    @Test
    public void isRainy() {
        assertTrue(forecast.isRainy());
    }


}