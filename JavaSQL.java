package capstone;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;

public class JavaSQL {
    Connection conn = null; //the connection to the SQL database
    //opens connection to the mySQL database, and prints to the console confirming the connection
    public void establishConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //defaulted to a localhost server, can be adjusted for proper deployment
            conn = DriverManager.getConnection("jdbc:mysql://localhost/capstone","root", "");
            System.out.println("Database is connected!");
        }
        catch(Exception e) {
            System.out.println("Did not connect to DB - Error: "+e);
        }
    }

    //closes connection to the mySQL database
    public void closeConnection() {
        try {
            conn.close();
            System.out.println("Closed the connection!");
        }
        catch (Exception e) {
            System.out.println("Couldn't close the connection! - Error: "+e);
        }
    }

    //pre-loads the "master" product with the entire table of ingredients
    public void preLoadDatabase(Product rootP) {
        try {
            Statement smt = conn.createStatement();

            ResultSet rs = smt.executeQuery("SELECT Name, Description FROM ingredients");

            //System.out.println("Contents of the Table");
            while(rs.next()) {
                rootP.getIngList().add(new Ingredient(rs.getString("Name"), rs.getString("Description")));
                //System.out.println("Added Ingredient: "+rs.getString("Name")+" with description: "+rs.getString("Description"));
            }
            smt.close();
        }
        catch(Exception e) {
            System.out.println("Couldn't preload the ingredients! - Error: "+e);
        }
    }

    //loads the entire table of products and returns an observable list to be used in a ComboBox
    public ObservableList<String> loadProducts() {
        ObservableList<String> data = FXCollections.observableArrayList();
        try {
            Statement smt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = smt.executeQuery("SELECT Name FROM products");

            if (rs.next()) {
                rs.first();
                do {
                    data.add(rs.getString("Name"));
                }
                while (rs.next());
            }
            smt.close();
        }
        catch (Exception e) {
            System.out.println("Couldn't load products! - Error: "+e);
        }
        return data;
    }

    //checks if the passed product name (string) matches any of the names in the products table
    //returns true if it *is* a new product (matching not found, returns false if it *isn't* a new product (match found)
    public boolean isNewProduct(String name) {
        try {
            Statement smt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = smt.executeQuery("SELECT Name FROM products");
            if (rs.next()) {
                rs.first();
                do {
                    if (rs.getString("Name").equals(name)) {
                        return false;
                    }
                }
                while (rs.next());
            }
            smt.close();
            return true;
        }
        catch (Exception e) {
            System.out.println("Couldn't check if it's a new product! - Error: "+e);
            return false;
        }
    }

    //adds a product to the products table, with the name and comma-separated ingredient list passed in for the columns
    public void addProduct(String name, String ingredients) {
        try {
            Statement smt = conn.createStatement();
            smt.execute("INSERT INTO products (Name, IngList) VALUES ('"+name+"', '"+ingredients+"')");
            smt.close();
        }
        catch (Exception e) {
            System.out.println("Couldn't add the new product! - Error: "+e);
        }
    }

    //retrieves a product's ingredient list from the database, with the name of the product to be found passed in
    public String getProductIng (String name) {
        try {
            Statement smt = conn.createStatement();
            ResultSet rs = smt.executeQuery("SELECT Name, IngList FROM products");
            while(rs.next()) {
                if (rs.getString("Name").equals(name)) {
                    return rs.getString("IngList");
                }
            }
            smt.close();
            return "No List Found!";
        }
        catch (Exception e) {
            System.out.println("Couldn't get the product's ingredients! - Error: "+e);
            return "No List Found!";
        }
    }
}
