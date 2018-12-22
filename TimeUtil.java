package com.gary.dida;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author gary
 */
public class TimeUtil {
    private static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss:SSS";

    public static String timeString(String message) {
        return new SimpleDateFormat(TIME_PATTERN).format(Calendar.getInstance().getTime()) + message;
    }
}
