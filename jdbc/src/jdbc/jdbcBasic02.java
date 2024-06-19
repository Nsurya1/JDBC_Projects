package jdbc;

import java.sql.*;

public class jdbcBasic02 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/collage";
        String userName = "root";
        String password = "nitesh@123";

        String query = "INSERT INTO student VALUES (108, 'mohit', 25)";

        try {
            // Load and register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection(url, userName, password);

            // Create a statement
            Statement st = con.createStatement();

            // Execute the query
            int count = st.executeUpdate(query);

            // Display the number of rows affected
            System.out.println(count + " row(s) affected");

            // Close the statement and connection
            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Include the JDBC library in your classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL error occurred.");
            e.printStackTrace();
        }
    }
}
