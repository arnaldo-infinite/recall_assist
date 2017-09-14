/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ByDayy 
{
    String RID;
    String Date;
    String WordScore;
    int Occurance;
    String [] occurdates;
    
    
    
    ConnectionClass objCon = new ConnectionClass();
    DateManager dmanager = new DateManager();
    Connection con;
    
    public ByDayy (String RID) throws ParseException
    {
        this.RID=RID;
        Date=RID.substring(0,10);
        dmanager.setDates(Date);
        
        setWordScore();
        setOccurance ();
    }
    
    
    private void setWordScore()
    {
        String WordsScore="";
        try
        { 
            con=objCon.getConnection();
            PreparedStatement stat1=con.prepareStatement("select Words_Score from recordings where RID=?");
            stat1.setString(1,this.RID);
            ResultSet rst1=stat1.executeQuery();
            
            while(rst1.next())
            {
                WordsScore= rst1.getString("Words_Score");
            } 
        }
        catch(Exception e )
        {
            JOptionPane.showMessageDialog(null,"Error When Searching Words Score "+e.toString());
        }
        finally
        {
            try 
            {
                con.close();
            } 
            catch (SQLException ex) 
            {
                JOptionPane.showMessageDialog(null,"Error When Searching Words Score "+ex.toString());
            }
        }
        this.WordScore=WordsScore;
    }
    
    
    private void setOccurance ()
    {
        int Occurance=0;
        int count=0;
        
        String Day1=dmanager.getDay1()+"%";
        String Day2=dmanager.getDay2()+"%";
        String Day3=dmanager.getDay3()+"%";
        String Day4=dmanager.getDay4()+"%";
        String Day5=dmanager.getDay5()+"%";
        String Day6=dmanager.getDay6()+"%";
        
        try
        { 
            con=objCon.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//            PreparedStatement stat1=con.prepareStatement("select RID,Words_Score from recordings where (RID like '"+Day1+"' OR RID like '"+Day2+"' OR RID like '"+Day3+"' OR RID like '"+Day4+"' OR RID like '"+Day5+"' OR RID like '"+Day6+"') AND Words_Score='"+WordScore+"'");
            
            ResultSet rst1=stmt.executeQuery("select RID,Words_Score from recordings where (RID like '"+Day1+"' OR RID like '"+Day2+"' OR RID like '"+Day3+"' OR RID like '"+Day4+"' OR RID like '"+Day5+"' OR RID like '"+Day6+"') AND Words_Score='"+WordScore+"' order by RID asc");
            
            while(rst1.next())
            {
                Occurance++;
            } 
            occurdates = new String[Occurance];
            
            rst1.beforeFirst();
            
            while(rst1.next())
            {
                String temp=rst1.getString("RID");
                occurdates[count]=temp.substring(0,10);
                count++;
            } 
            
        }
        catch(Exception e )
        {
            JOptionPane.showMessageDialog(null,"Error When Searching Occurance "+e.toString());
        }
        finally
        {
            try 
            {
                con.close();
            } 
            catch (SQLException ex) 
            {
                JOptionPane.showMessageDialog(null,"Error When Searching Occurance "+ex.toString());
            }
        }
        this.Occurance=Occurance;
    }
    
    
    
    
    
    
    
    
    public int getOccurance()
    {
        return this.Occurance;
    }
    
     public String getWordScore()
    {
        return this.WordScore;
    }
     
     public String [] getOccureDates()
    {
        return this.occurdates;
    }
     

     
     
    public float getPercentageByDay()
    {
        float Percentage;
        Percentage = (float) (Occurance*100)/6;
        return Percentage;
    }
    
//    public static void main(String[] args) throws Exception
//    {
//        
//        ByDay manager = new ByDay("2017-09-03-1");
//        int Occurance=manager.getOccurance();
//        float temp = (float)Occurance*100/6;
//        System.out.println(temp);
//    }
}
