package br.uvv.inovatech.study.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static final String DATE_FORMAT_DDMMYYY_HHMM = "dd/MM/yyyy HH:mm";

    public static String formatDateToString(Date date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
