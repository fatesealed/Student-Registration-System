package com.wzs.comm.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author dell
 * @date 2020/7/20 11:28 DateUtils
 * util 功能
 */

public class DateUtils {
    public static String getCurrentTime(){
        Date day=new Date();
        SimpleDateFormat f=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String str=f.format(day);
        return str;
    }
    public static String onlyGetDate(){
        Date day=new Date();
        SimpleDateFormat f=new SimpleDateFormat("YYYY-MM-dd");
        String str=f.format(day);
        return str;
    }
}
