package com.base.wang.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtil implements Serializable {

    private static final long serialVersionUID = 5L;


    /**
     * 将Date 时间转换为指定格式的字符串
     * @param date
     * @param pattern
     * @return
     */
    public static String formatDateToString(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        if (date == null) {
            return "";
        }
        return sdf.format(date);
    }

    /**
     * 将指定格式的字符串转换为时间
     * @param date
     * @param format
     * @return
     */
    public static Date getFormatDate(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date d = null;
        try {
            d = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    /**
     * 将字符串按yyyy-MM-dd HH:mm:ss格式转换为一天后的时间
     * @param date
     * @return
     */
    public static Date getFormatDateAfterOne(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = null;
        try {
            d = sdf.parse(date);
            d.setTime(d.getTime() + 24*60*60*1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    /**
     * 将字符串按yyyy-MM-dd HH:mm:ss格式转换为前一天的时间
     * @param date
     * @return
     */
    public static Date getFormatDateBeforeOne(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = sdf.parse(date);
            d.setTime(d.getTime() - 24*60*60*1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    /**
     * 将字符串按yyyy-MM-dd格式转换为一天后的时间
     * @param date
     * @return
     */
    public static Date getFormatDateAfterOne(String date, String format) {
        if (format == null || "".equals(format.trim())) {
            format = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date d = null;
        try {
            d = sdf.parse(date);
            d.setTime(d.getTime() + 24*60*60*1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    /**
     * 获得本周一0点时间
     */
    public static Date getTimesWeekmorning() {
        Calendar cal = Calendar.getInstance();
        //如果是周日，直接调用获取的是下周周一时间
        if (1 == cal.get(Calendar.DAY_OF_WEEK)){
            cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 7);
        }
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }


    /**
     * 获得过去 N 年的日期
     */

    public static String getPastYearDate(Integer years){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();

        //过去一年
        c.setTime(new Date());
        c.add(Calendar.YEAR, -years);
        Date y = c.getTime();
        String year = format.format(y);

        return year;
    }

    //间隔天数 整数
    public static int daysBetween(Date bfdate,Date afdate) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        bfdate=sdf.parse(sdf.format(bfdate));
        afdate=sdf.parse(sdf.format(afdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(bfdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(afdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    //间隔天数 整数(当天表示一天)
    public static int useDaysBetween(Date bfdate,Date afdate) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        bfdate=sdf.parse(sdf.format(bfdate));
        afdate=sdf.parse(sdf.format(afdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(bfdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(afdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);
        int count = Integer.parseInt(String.valueOf(between_days));
        if(count == 0){
            count = 1;
        }
        return count;
    }

    //间隔天数 小数
    public static BigDecimal daysBetweenNum(Date bfdate,Date afdate) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
        bfdate=sdf.parse(sdf.format(bfdate));
        afdate=sdf.parse(sdf.format(afdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(bfdate);
        double time1 = cal.getTimeInMillis();
        cal.setTime(afdate);
        double time2 = cal.getTimeInMillis();
        BigDecimal a = new BigDecimal((time2-time1));
        double between_days =  a.divide(new BigDecimal(1000*3600*24),24,BigDecimal.ROUND_HALF_UP).doubleValue();

        return new BigDecimal(between_days);
    }


    public static String getWeekOfDate(Date date) {
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0){
            w = 0;
        }

        return weekDays[w];

    }
    
    /**
     * 解析format指定的格式的日期
     */
    public static Date parseDate(String date, String format) {
        return parseDate(date, new SimpleDateFormat(format));
    }


    /**
     * 解析format指定的格式的日期
     */
    public static Date parseDate(String date, SimpleDateFormat format) {
        try {
            return format.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException("Date parse error: " + date
                    + " , expected format is " + format.toPattern(), ex);
        }
    }
    /***
     * 当前时间多少天后的00:00:00
     */
    public static Date addDateStartTime(Date date,int addDate) {
        Calendar para = Calendar.getInstance(java.util.Locale.CHINA);
        para.setTime(date);
        para.add(Calendar.DATE,addDate);
        para.set(Calendar.HOUR_OF_DAY, 0);
        para.set(Calendar.MINUTE, 0);
        para.set(Calendar.SECOND,0);
        para.set(Calendar.MILLISECOND,0);
        return para.getTime();
    }
    /***
     * 当前时间多少天后的00:00:00
     */
    public static Date addDateEndTime(Date date,int addDate) {
        Calendar para = Calendar.getInstance(java.util.Locale.CHINA);
        para.setTime(date);
        para.add(Calendar.DATE,addDate);
        para.set(Calendar.HOUR_OF_DAY, 23);
        para.set(Calendar.MINUTE, 59);
        para.set(Calendar.SECOND,59);
        para.set(Calendar.MILLISECOND,0);
        return para.getTime();
    }
    /***
     * 当前时间多少天后的年月日
     */
    public static String addDateTime(Date date,int addDate) {
        Calendar para = Calendar.getInstance(java.util.Locale.CHINA);
        para.setTime(date);
        para.add(Calendar.DATE,addDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(para.getTime());
    }

    public static void main(String[] args){
        System.out.println(addDateTime(new Date(),-2));
    }
}
