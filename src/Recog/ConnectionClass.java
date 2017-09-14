/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recog;

import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ConnectionClass 
{
    public java.sql.Connection getConnection(){
    java.sql.Connection con=null;
    try
    {
       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        con=DriverManager.getConnection("jdbc:odbc:deg_final","","");
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,new String ("Error Connecting To Database "+e));
    }
    return con;
}    
}
