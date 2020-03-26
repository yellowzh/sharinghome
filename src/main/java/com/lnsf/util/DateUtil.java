package com.lnsf.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static String dayago(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();

        c.add(Calendar.DATE, - 5);

        Date time = c.getTime();

        String preDay = sdf.format(time);
        return preDay;
    }
}
