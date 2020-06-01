package Sys;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TimeFormats {

    public static String timeConvert(String time) {
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat("H:mm:ss");
            final Date dateObj = sdf.parse(time);
            
            time= new SimpleDateFormat("H:mm aa").format(dateObj);
        } catch (final ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

//    public static void main(String[] args) throws Exception {
//        final String time = "15:15:00";
//        System.out.println(TimeFormats.timeConvert(time));
//    }
}
