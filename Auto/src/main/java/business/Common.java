package business;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Common {
    // set to true to record test results to TestRail
    public static Boolean postResultsToTestRail = true;
    public static Boolean debugInfo = true;

    public static String dateTimeString() {
        String out = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        return out;
    }

    public static String dateString() {
        String out = new SimpleDateFormat("yyyyMMdd").format(new Date());
        return out;
    }


}
