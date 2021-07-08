package com.edts.tdlib.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneralUtil {

    public static Date strToDate(String strDate, String format) throws ParseException {
        Date resultDate = new SimpleDateFormat(format).parse(strDate);
        return resultDate;
    }

    public static String dateToStr(Date date, String format) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String strDate = formatter.format(date);
        return strDate;
    }

}
