import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Pattern;

public class Pesel {
    String pesel;
    private int PESEL[] = new int[11];
    //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    Pesel(String p){
        pesel=p;
        for (int i = 0; i < pesel.length(); i++) {
            PESEL[i] = Integer.parseInt(String.valueOf(pesel.charAt(i)));
        }
    }
    private boolean isValid(){
        if(pesel.length()!=11){
            return false;
        }else{
            int sum = 1 * PESEL[0] +
                    3 * PESEL[1] +
                    7 * PESEL[2] +
                    9 * PESEL[3] +
                    1 * PESEL[4] +
                    3 * PESEL[5] +
                    7 * PESEL[6] +
                    9 * PESEL[7] +
                    1 * PESEL[8] +
                    3 * PESEL[9];
            sum %= 10;
            sum = 10 - sum;
            sum %= 10;

            if (sum == PESEL[10]) {
                return true;
            }
            else {
                return false;
            }

        }

    }
    private int getBirthYear() {
        int year;
        int month;
        year = 10 * PESEL[0];
        year += PESEL[1];
        month = 10 * PESEL[2];
        month += PESEL[3];
        if (month > 80 && month < 93) {
            year += 1800;
        }
        else if (month > 0 && month < 13) {
            year += 1900;
        }
        else if (month > 20 && month < 33) {
            year += 2000;
        }
        else if (month > 40 && month < 53) {
            year += 2100;
        }
        else if (month > 60 && month < 73) {
            year += 2200;
        }
        return year;
    }
    private int getBirthMonth() {
        int month;
        month = 10 * PESEL[2];
        month += PESEL[3];
        if (month > 80 && month < 93) {
            month -= 80;
        }
        else if (month > 20 && month < 33) {
            month -= 20;
        }
        else if (month > 40 && month < 53) {
            month -= 40;
        }
        else if (month > 60 && month < 73) {
            month -= 60;
        }
        return month;
    }
    private int getBirthDay() {
        int day;
        day = 10 * PESEL[4];
        day += PESEL[5];
        return day;
    }


    private LocalDate getDate(){
        int day=getBirthDay();
        int month =getBirthMonth();
        int year =getBirthYear();
        return LocalDate.of(year,month,day);

    }
    private Sex getSex(){
        if (PESEL[9] % 2 == 1) {
            return Sex.MALE;
        }
        else {
            return Sex.FEMALE;
        }
    }

}
enum Sex{
    MALE,
    FEMALE
}
