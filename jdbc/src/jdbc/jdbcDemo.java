/*
 * import --- java.sql
 * load and register the driver
 * Create Connection
 * Create statement
 * execute query
 * process the results
 * close
 * 
 * */

package jdbc;
import java.sql.*;

public class jdbcDemo { 
  public static void main(String arg[]){
	  String url = "jdbc:mysql://localhost:3306/collage";

    String username = "root";
    String password = "nitesh@123";
//    String query = "select name from student where id = 102;";
    String query = "Select * from student";

    try {
    
    // Load and register the driver
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    // Create a connection
    Connection con = DriverManager.getConnection(url, username, password);
    
    // Create a statement
    Statement st = con.createStatement();
    
    // Execute query
    ResultSet rs = st.executeQuery(query); //DDL for get value

    
    // Process the results
    if(rs.next()) {
      String name = rs.getString("name");
      System.out.println(name);
    } else {
      System.out.println("No record found with id = 102");
    }
    
     String userData = "";
    while(rs.next()) {
   	userData = rs.getInt(1) + ":" + rs.getString(2) + ":" + rs.getInt(3);
  	System.out.println(userData);
    }
    
    
    // Close the statement and connection
    st.close();
    con.close();
  }catch (ClassNotFoundException e) {
      System.err.println("MySQL JDBC Driver not found. Include the JDBC library in your classpath.");
//      e.printStackTrace();
  } catch (SQLException e) {
      System.err.println("SQL error occurred.");
//      e.printStackTrace();
  }
}
}

