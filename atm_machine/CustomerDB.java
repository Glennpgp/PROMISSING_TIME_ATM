/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm_machine;

import java.sql.*;



/**
 *
 * @author glenn
 */
public final class CustomerDB {

    private static final String USER_NAME = "pdc";
    private static final String PASSWORD = "pdc";
    private static final String URL = "jdbc:derby:CustomerDB; create=true";

    private final java.sql.Connection con;
    private java.sql.Statement statement;

    public CustomerDB() throws ClassNotFoundException {
        con = getConnection();
    }
    

    public static Connection getConnection() throws ClassNotFoundException {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println(URL + "Connection Established");
            return con;
        } catch (SQLException ex) {
            System.err.println("SQL Exception: " + ex.getMessage());
                return null;
        }
        
    }

    public void connectCustomerDB(){
        //getConnection();
        try {
            this.statement = con.createStatement();
            this.checkExistedTable("CUSTOMER"); 
//            this.statement.addBatch("CREATE  TABLE CUSTOMER  (CUSTOMERID  INT,   PINCODE   INT,   FirstName   VARCHAR(20),   LastName  VARCHAR(50), "
//                    + "EmailID  VARCHAR(50), Address VARCHAR(50), PhoneNumber INT, AccountBalance INT )");
//            this.statement.addBatch("INSERT INTO CUSTOMER (CUSTOMERID, PINCODE, FirstName, LastName, EmailID, Address, PhoneNumber, AccountBalance ) "
//                    + " VALUES (123456, 1234, 'glenn', 'neil', 'glenn@yahoo.com', 'howick', 0224076236, 100), " 
//                   + "(654321, 4321, 'anita', 'wason', 'anita@gmail.com', 'flatbush', 653745238, 50), "
//                   + "(21132847, 1111, 'sam', 'watson', 'sammy@gmail.com', 'pakuranga', 0226352178, 20)");
               //this.statement.addBatch("ALTER TABLE CUSTOMER ALTER COLUMN ACCOUNTBALANCE INT");
               //this.statement.addBatch("DROP TABLE CUSTOMER");
            this.statement.executeBatch();
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    

    public void checkExistedTable(String name) {
        try {
            DatabaseMetaData dbmd = this.con.getMetaData();
            String[] types = {"TABLE"};
            statement = this.con.createStatement();
            ResultSet rs = dbmd.getTables(null, null, null, types);

            while (rs.next()) {
                String table_name = rs.getString("TABLE_NAME");
                System.out.println(table_name);
                if (table_name.equalsIgnoreCase(name)) {
                    statement.executeUpdate("Drop table " + name);
                    System.out.println("Table " + name + " has been deleted.");
                    break;
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    


    public static void main(String[] args) throws ClassNotFoundException {
        CustomerDB cus = new CustomerDB();
        cus.connectCustomerDB();
        //cus.closeConnections();
        
        

    }

    public void closeConnections() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
