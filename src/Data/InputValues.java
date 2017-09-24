/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class InputValues 
{
    String RID;
    String Date;
    double tWS [];
    double tWC [];
    
    ConnectionClass objCon = new ConnectionClass();
    DateManager dmanager = new DateManager();
    Connection con;
    
    public InputValues (String Date) throws ParseException
    {
        this.Date=Date;
        fillinput(this.Date);
    }
    
    private void fillinput (String DateValue)
    {
        int count=0;    
        String Day1=DateValue+"%";
        try
        { 
            con=objCon.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//            PreparedStatement stat1=con.prepareStatement("select RID,Words_Score from recordings where (RID like '"+Day1+"' OR RID like '"+Day2+"' OR RID like '"+Day3+"' OR RID like '"+Day4+"' OR RID like '"+Day5+"' OR RID like '"+Day6+"') AND Words_Score='"+WordScore+"'");
            
            ResultSet rst1=stmt.executeQuery("select RID,Words_Score,No_Words from word where RID like '"+Day1+"' order by RID asc");
            
            while(rst1.next())
            {
                count++;
            }
            
            tWS = new double[count];
            tWC= new double[count];
            rst1.beforeFirst();
            
            count=0;
            while(rst1.next())
            {
                tWS[count] =Double.parseDouble(rst1.getString("Words_Score"));
                tWC[count]=Double.parseDouble(rst1.getString("No_Words"));
                count++;
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
    
    
    public double [] gettWC()
    {
        return this.tWC;
    }
     
      public double [] gettWS()
    {
        return this.tWS;
    }
    
    
    
    
    
}
