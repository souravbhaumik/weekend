import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class App
{
    public static void main( String[] args ) throws Exception
    {
        String URL = "jdbc:postgresql://localhost:5432/store_db";
        String USERNAME = "postgres";
        String PASSWORD = "Tinni@29";

        String[] names = {"Tinni", "Garima", "Shilpa", "Saloni", "Kavya"};
        int[] ages = {26, 26, 24, 25, 24};
        int len = 0;

        String query = "SELECT * FROM CUSTOMERS;";
        String addColumnCheck = "SELECT * FROM information_schema.columns WHERE table_name='customers' and column_name='age';";
        String addColumn = "ALTER TABLE CUSTOMERS ADD COLUMN AGE INT DEFAULT 18;";
        String insertQuery = "insert into customers(cust_name, age) values ('Sourav', 26);";
        String updateQuery = "UPDATE CUSTOMERS SET AGE=27 WHERE CUST_ID=5;";
        String deleteQuery = "DELETE FROM CUSTOMERS WHERE CUST_ID=6;";

        String PreparedQuery = "insert into customers (cust_name, age) values (?, ?)";
        

        /*
         * Import package
         * Load and register
         * Create connection
         * Create statement
         * Execute statement
         * Process the results
         * Close the resultSet
        */

        Connection con = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        Statement stmt = con.createStatement();

        if (!stmt.executeQuery(addColumnCheck).next())
            stmt.executeUpdate(addColumn);

        if (!stmt.executeQuery("SELECT * FROM CUSTOMERS WHERE CUST_NAME='Sourav'").next())
            stmt.executeUpdate(insertQuery);

        // stmt.executeUpdate(updateQuery);
        // stmt.executeUpdate(deleteQuery);

        PreparedStatement pstmt = con.prepareStatement(PreparedQuery);
        if ((len = names.length) == ages.length)
        {
            for (int i = 0; i < len; i++) {
                pstmt.setString(1, names[i]);
                pstmt.setInt(2, ages[i]);
                pstmt.execute();
            }
        }

        ResultSet rs = stmt.executeQuery(query);
        while (rs.next())
        {
            System.out.println("Customer ID = " + rs.getString("CUST_ID") + ", Customer name = " + rs.getString("CUST_NAME") + ", Customer age = " + rs.getString("AGE"));
        }
        con.close();        
    }
}
