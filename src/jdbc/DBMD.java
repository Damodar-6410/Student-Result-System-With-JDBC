
package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

public class DBMD {
    public static void main(String[] args) {
          try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
            System.out.println("Connection established successfully");
          
              DatabaseMetaData dbmd = con.getMetaData();
              System.out.println(dbmd.getDatabaseProductName());
              System.out.println(dbmd.getDatabaseProductVersion());
              System.out.println(dbmd.getDriverName());
              System.out.println(dbmd.getDriverVersion());
              System.out.println(dbmd.getConnection());
        }
        catch(Exception e){
             System.out.println("Connection could not be established successfully");
             System.out.println(e);
        }
    }
}
