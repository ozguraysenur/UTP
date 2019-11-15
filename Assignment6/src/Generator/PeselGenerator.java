package Generator;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class PeselGenerator {


    private boolean valid = false;
    static int[] multiply={1,3,7,9,1,3,7,9,1,3};

    public static String generate(Date birth){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(birth);
        int year = calendar.get(Calendar.YEAR);
        int month =calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String madd = monthadding(year,month,day);
        madd += randomFour();
        int controldigit = checkSum(madd);
        madd+=String.valueOf(controldigit);
        if(madd.length()!=11){
            return "ERROR";
        }
        return madd;
    }
    public static String monthadding(int year ,int month,int day){
        int century =year / 100;
        month=month+1;
        int lastTwo=year%100;
        int m =1;
        switch (century){
            case 18:
                m=month+80;
                break;
            case 19:
                m=month ;
                break;
            case 20:
                m=month+20;
                break;
            case 21:
                m=month+40;
                break;
            case 22:
                m= month+60;
                break;
        }
        return String.format("%02d%02d%02d",lastTwo,m,day);

    }
    public static String randomFour(){
        Random random =new Random();
        return String.format("%04d", random.nextInt(10000));
    }


    public boolean isValid() {
        return valid;
    }


    public static String getSex(String a) {
            if (a.charAt(9) % 2 == 1) {
                return "men";
            }
            else {
                return "women";
            }
    }

    public static int checkSum(String last) {
        //check the validity of the number
        int sum= 0;
        for (int i = 0; i < multiply.length; i++) {
            int digit= last.charAt(i) - '0';
            sum +=multiply[i]*digit;
        }
        //The checksum is the last digit of result of the above expression subtracted from 10. If this last digit is 0 then the checksum is 0.
        //If the result of the last operation is not equal to the last digit (K) of a given PESEL, the PESEL is incorrect
         int mod=sum % 10;
        if (mod==0) {
            return mod;
        }
        else {
            return 10-mod;
        }
    }



}
