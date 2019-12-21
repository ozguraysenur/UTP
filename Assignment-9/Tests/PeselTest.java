import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;

public class PeselTest {
    Pesel pesel = new Pesel("70061715791");

    @Test
    public void isValid(){
        try {
            Method method = Pesel.class.getDeclaredMethod("isValid");
            method.setAccessible(true);
            Boolean result = (Boolean) method.invoke(pesel);
            Assert.assertEquals(true,result);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void getDate(){
        Method method = null;
        try {
            method = Pesel.class.getDeclaredMethod("getDate");
            method.setAccessible(true);
            LocalDate result = (LocalDate) method.invoke(pesel);
            Assert.assertEquals(LocalDate.of(1970,06,17),result);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void getSex(){
        Method method = null;
        try {
            method = Pesel.class.getDeclaredMethod("getSex");
            method.setAccessible(true);
            Sex result = (Sex) method.invoke(pesel);
            Assert.assertEquals(Sex.MALE,result);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
