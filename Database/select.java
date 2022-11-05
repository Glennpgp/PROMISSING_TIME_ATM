/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;


import atm_machine.CustomerDB;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;


/**
 *
 * @author glenn
 */
public class select {
    
    public static ResultSet getData(String Query) throws ClassNotFoundException {

        //Declaration of variables for statement, resultset and connection
        Connection con = null;
        ResultSet rs = null;
        Statement st = null;

        try {
            con = (Connection) CustomerDB.getConnection();
            st = con.createStatement();

            //data selection and return
            rs = st.executeQuery(Query);
            //Returning the result
            return rs;

            //Catching any potential errors
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            return null;
        } catch (NullPointerException ex) {
            return null;
        }

    }
    
    public void myUpdate(String sql) throws ClassNotFoundException {

        Connection connection =  CustomerDB.getConnection();
        Statement statement = null;
        
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql); 

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
   
    
    
    
}
