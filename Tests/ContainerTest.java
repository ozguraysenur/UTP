import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ContainerTest {


    Container<Weather, Integer> contain;
    Weather weather;

    @Before
    public void before() throws Exception {
        contain =new Container<>();
        weather=new Weather(25);
        contain.addElement(weather);

    }
    @Test
    public void getElements() {

        Assert.assertEquals(Arrays.asList(weather), contain.getElements());
    }

    @Test
    public void aggregateAllElements() {
        //int aggragate =(Integer) contain.aggregateAllElements();
        // Assert.assertEquals(aggragate,25);
        assertEquals(25,(int) contain.aggregateAllElements());
    }

    @Test
    public void cloneElementAtIndex() {
        Weather clone = contain.cloneElementAtIndex(0);
        Assert.assertEquals(clone.getDegree(), weather.getDegree());
        Assert.assertNotSame(clone, weather);
    }
}