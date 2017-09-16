/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recog;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author User
 */
public class DateManager 
{
    private String Day1;
    private String Day2;
    private String Day3;
    private String Day4;
    private String Day5;
    private String Day6;
    private String yesterday;
    private String DBY;
    private String Today;
    
    public void setDates(String Date) throws ParseException
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(Date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

//        //Add one day to current date.
//        cal.add(Calendar.DATE, 1);
//        System.out.println(dateFormat.format(cal.getTime()));

        //Substract one day to current date.
        cal.add(Calendar.DATE, -7);
        Day1=dateFormat.format(cal.getTime());
        
        cal.add(Calendar.DATE, -7);
        Day2=dateFormat.format(cal.getTime());
        
        cal.add(Calendar.DATE, -7);
        Day3=dateFormat.format(cal.getTime());
        
        cal.add(Calendar.DATE, -7);
        Day4=dateFormat.format(cal.getTime());
        
        cal.add(Calendar.DATE, -7);
        Day5=dateFormat.format(cal.getTime());
        
        cal.add(Calendar.DATE, -7);
        Day6=dateFormat.format(cal.getTime());
    }
    
    public void genYesterday(String Date) throws ParseException
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(Date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
        cal.add(Calendar.DATE, -1);
        yesterday=dateFormat.format(cal.getTime());
    }
    
    public String genTomorrow(String Date) throws ParseException
    {
        String Tommorow;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(Date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
        cal.add(Calendar.DATE, +1);
        Tommorow=dateFormat.format(cal.getTime());
        
        return Tommorow;
    }
    
    public void genDBY(String Date) throws ParseException
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(Date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
        cal.add(Calendar.DATE, -2);
        DBY=dateFormat.format(cal.getTime());
    }
    
    public String getToday ()
    {
        String Today;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
        Today=dateFormat.format(cal.getTime());
        
        return Today;
    }
    
    public String genDAT(String Date) throws ParseException
    {
        String DayAfterTommorrow;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(Date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        
        cal.add(Calendar.DATE, +2);
        DayAfterTommorrow=dateFormat.format(cal.getTime());
        
        return DayAfterTommorrow;
    }
    
//    public static void main(String[] args) throws Exception
//    {
//        
//        DateManager manager = new DateManager();
//        manager.setDates("2017-09-11");
//    }

    /**
     * @return the Day1
     */
    public String getDay1() {
        return Day1;
    }

    /**
     * @return the Day2
     */
    public String getDay2() {
        return Day2;
    }

    /**
     * @return the Day3
     */
    public String getDay3() {
        return Day3;
    }

    /**
     * @return the Day4
     */
    public String getDay4() {
        return Day4;
    }

    /**
     * @return the Day5
     */
    public String getDay5() {
        return Day5;
    }

    /**
     * @return the Day6
     */
    public String getDay6() {
        return Day6;
    }

    /**
     * @return the yesterday
     */
    public String getYesterday() {
        return yesterday;
    }
    

    /**
     * @return the DBY
     */
    public String getDBY() {
        return DBY;
    }
    
    public DateManager() 
    {

    }
    
}
