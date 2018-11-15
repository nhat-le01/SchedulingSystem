import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class createUser {
	public static void main(String[] args) {
		//Runtime.getRuntime().exec(new String[] {"cmd", "/K", "Start"});
		try
        { 
            // Just one line and you are done !  
            // We have given a command to start cmd 
            // /K : Carries out command specified by strig 
           Runtime.getRuntime().exec(new String[] {"cmd", "/K", "Start"}); 
  
        } 
        catch (Exception e) 
        { 
            System.out.println("HEY Buddy ! U r Doing Something Wrong "); 
            e.printStackTrace(); 
        } 
		String query = "create user 'Steven'@'localhost' identified by 'xxxx';";
		try (
				//String query = "create user 'Steven'@'localhost' identified by 'xxxx';";
		         // Step 1: Allocate a database 'Connection' object
		         Connection conn = DriverManager.getConnection(
		               "jdbc:mysql://localhost:3306/ebookshop?useSSL=false", "nhatle", "xxxx");
		               // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
		 
		         // Step 2: Allocate a 'Statement' object in the Connection
		         Statement stmt = conn.createStatement();
		      ) {
		         // Step 3: Execute a SQL SELECT query, the query result
		         //  is returned in a 'ResultSet' object.
		         String strSelect = "select title, price, qty from books";
		         System.out.println("The SQL query is: " + strSelect); // Echo For debugging
		         System.out.println();
		 
		         ResultSet rset = stmt.executeQuery(strSelect);
		 
		         // Step 4: Process the ResultSet by scrolling the cursor forward via next().
		         //  For each row, retrieve the contents of the cells with getXxx(columnName).
		         System.out.println("The records selected are:");
		         int rowCount = 0;
		         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
		            String title = rset.getString("title");
		            double price = rset.getDouble("price");
		            int    qty   = rset.getInt("qty");
		            System.out.println(title + ", " + price + ", " + qty);
		            ++rowCount;
		         }
		         System.out.println("Total number of records = " + rowCount);
		 
		      } catch(SQLException ex) {
		         ex.printStackTrace();
		      }
	}
}
