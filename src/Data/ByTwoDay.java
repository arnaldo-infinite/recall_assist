/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ByTwoDay 
{
    String RID;
    String Date;
    String SearchDate;
    int WordScore;
    int [] WordScoresArray;
    String [] occurdates;
    String [] date;
    
    double tWS [];
    double tWC [];
    double output [];
    
    ConnectionClass objCon = new ConnectionClass();
    DateManager dmanager = new DateManager();
    Connection con;
    
    public ByTwoDay (String RID, String [] Occurdates) throws ParseException
    {
        this.RID=RID;
        Date=RID.substring(0,10);
        SearchDate = Date;
        this.occurdates=Occurdates;
                
        dmanager.setDates(Date);
        
        setWordScore();
//        fillwordsscore();
        
        dmanager.genDBY(Date);
        String DBY = dmanager.getDBY();
        dmanager.setDates(DBY);
        fillInputs();
//        genCorrectOutputs();
    }
    
    private void setWordScore()
    {
        int WordsScore=0;
        try
        { 
            con=objCon.getConnection();
            PreparedStatement stat1=con.prepareStatement("select Words_Score from word, recording where word.RID=? AND word.RID=recording.RID");
            stat1.setString(1,this.RID);
            ResultSet rst1=stat1.executeQuery();
            
            while(rst1.next())
            {
                WordsScore= rst1.getInt("Words_Score");
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
    
    private void fillInputs ()
    {
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
            
            ResultSet rst1=stmt.executeQuery("select RID,Words_Score,No_Words from word where RID like '"+Day1+"' OR RID like '"+Day2+"' OR RID like '"+Day3+"' OR RID like '"+Day4+"' OR RID like '"+Day5+"' OR RID like '"+Day6+"' order by RID asc");
            
            while(rst1.next())
            {
                count++;
            } 
            
            tWS = new double[count];
            tWC= new double[count];
            output = new double [count];
            date = new String[count];
            rst1.beforeFirst();
            
            count=0;
            while(rst1.next())
            {
                String tdate = (rst1.getString("RID")).substring(0,10);
                tdate=dmanager.genDAT(tdate);
                date[count] = tdate;
                tWS[count] =Double.parseDouble(rst1.getString("Words_Score"));
                tWC[count]=Double.parseDouble(rst1.getString("No_Words"));
                count++;
            }             
             for (int i = 0 ; i<tWS.length; i++)
                {
                    for (int z = 0;z<occurdates.length;z++)
                    {
                        String cdate = date[i];
                        String odate= occurdates[z];
                        
                        if (cdate.equals(odate))
                        {
                            output[i]=1;
                            break;
                        }
                        else
                        {
                            output[i]=0;
                        }
                    }
                }
        }
        catch(Exception e )
        {
            JOptionPane.showMessageDialog(null,"Error When Searching Occurance 2 "+e.toString());
        }
        finally
        {
            try 
            {
                con.close();
            } 
            catch (SQLException ex) 
            {
                JOptionPane.showMessageDialog(null,"Error When Searching Occurance 3 "+ex.toString());
            }
        }
    }
    
    public double [] getOutputs()
    {
        return this.output;
    }
    
     public double [] gettWC()
    {
        return this.tWC;
    }
     
      public double [] gettWS()
    {
        return this.tWS;
    }
      
      
//          public static void main(String[] args) throws Exception
//    {
//    
//        ByDayy byday = new ByDayy("2017-09-04-2");
//        String [] Occurence=byday.getOccureDates();
//        ByTwoDay byoneday = new ByTwoDay("2017-09-04-2", Occurence);
//
//        double [] output = byoneday.getOutputs();
//        for (int i =0; i<output.length;i++)
//        {
//            System.out.println("Length "+output.length);
//        }
//    }
//    
}
