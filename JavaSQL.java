import java.sql.*;

public class JavaSQL {
    public void preLoadDatabase(Product rootP) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost/capstone","root", "");
            System.out.print("Database is connected!");

            Statement smt = conn.createStatement();

            ResultSet rs = smt.executeQuery("select Name, Description from ingredients");

            System.out.println("Contents of the Table");
            while(rs.next()) {
                rootP.getIngList().add(new Ingredient(rs.getString("Name"), rs.getString("Description")));
                System.out.println("Added Ingredient: "+rs.getString("Name")+" with description: "+rs.getString("Description"));
            }
            conn.close();
        }
        catch(Exception e) {
            System.out.print("Do not connect to DB - Error: "+e);
        }
    }
}
