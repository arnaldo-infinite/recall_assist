/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ConnectionClass 
{
    public Connection getConnection(){
    Connection con=null;
//    try
//    {
//       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//        con=DriverManager.getConnection("jdbc:odbc:deg_final","","");
//    }
//    catch(Exception e){
//        JOptionPane.showMessageDialog(null,new String ("Error Connecting To Database "+e));
//    }
//    return con;
    
    String url = "jdbc:postgresql://localhost:5432/voice_reg";
    try
        {
            Class.forName("org.postgresql.Driver");
            
            con = DriverManager.getConnection(url,"postgres","admin");
        }
        catch (Exception e1)
        {
            JOptionPane.showMessageDialog(null, "Error "+e1.toString());
        }
    return con;
}    
}
