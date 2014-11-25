import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;


public class ExDateFormat {

    public static void main(String[] args) {
        ExDateFormat c = new ExDateFormat();
        c.run();
    }

    private void run() {
        Date   d  = new Date();
        String ds = "April 20, 2014";

        DateFormat df = DateFormat.getDateInstance();
        try {
            d = df.parse(ds);
        }
        catch (ParseException e) {
            System.out.println("Unable to parse " + ds);
        }
        d.setTime(1000*60*60*24 + d.getTime());
    }
}