import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DressTest {

    private static final double PRICE =99.9;
    Dress pink =new Dress(PRICE);
    List<Dress> depo = new ArrayList<>();

    @Before
    public void before() throws Exception {
        depo.add(new Dress(89.9));
        depo.add(new Dress(79.9));
        Assert.assertEquals(PRICE,pink.getPrice(),0.01D);

    }

    @Test
    public void aggregate() {
        double aggregate = pink.aggregate(null);
        Assert.assertEquals(PRICE, aggregate,0.01D);
        final double init = 99.9;
        Assert.assertEquals((PRICE + init), (double) (pink.aggregate(init)), 0.01);
    }

    @Test
    public void deepClone() {
        Dress clone = pink.deepClone();
        Assert.assertEquals(pink.getPrice(), clone.getPrice(),0.01);
        Assert.assertNotSame(pink, clone);
    }
    @Test
    public void haveDiscount() {
        assertFalse(pink.haveDiscount());
    }
}