package Generator;

import java.util.Calendar;
import java.util.Date;

public class DateGenerator {
    static int currentyear = Calendar.getInstance().get(Calendar.YEAR);
    static int min= currentyear-60; //oldest max 60
    static int max= currentyear-20; //youngest min 20
    public static Date birthday(){
        int year= min +(int)(Math.random() * ((max - min) + 1));
        int month = 1 +(int)(Math.random() * 12);
        int day = 1 +(int)(Math.random() * 28);
        Calendar calendar =Calendar.getInstance();
        calendar.set(year,month,day);
        return calendar.getTime();
    }//add methos like hire date
    public static Date hiredate(){
        int year =birthday().getYear()+ 15;
        int month = 1 +(int)(Math.random() * 12);
        int day = 1 +(int)(Math.random() * 28);
        Calendar calendar =Calendar.getInstance();
        calendar.set(year,month,day);
        return calendar.getTime();

    }

}
