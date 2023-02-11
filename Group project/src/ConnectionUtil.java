import java.sql.*;


public class ConnectionUtil {
    public Connection connect_to_db(String dbname, String user, String pass) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (conn != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public void createTable(Connection conn, String recovery) {
        Statement statement;
        try {
            String query = "create table if not exists " + recovery + " (id SERIAL PRIMARY KEY NOT NULL, brand varchar(50), model varchar(50), price float);";
            statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("entering db information");
            System.out.println("please enter your social security number **1 to exit program**");
        }
    }

    public void insert_row(Connection conn, String brand, String model, double price) {
        Statement statement;
        try {
            String query = "INSERT INTO laptops (brand, model, price) VALUES ('" + brand + "', '" + model + "', " + price +")";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("row inserted");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void showLaptops(Connection conn, String recovery) throws SQLException {
        Statement statement;
        try {
            String query = "SELECT * FROM " + recovery + ";";
            statement = conn.createStatement();

            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                int id = result.getInt("id");
                String brandName = result.getString("brand");
                String modelName = result.getString("model");
                double pprice = result.getFloat("price");

                System.out.println(id + " " + brandName + " " + modelName + " " + pprice);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update(Connection conn, int idm, String brand, String model, double price) {
        Statement statement;
        try {
            String query = "UPDATE laptops SET brand = '" + brand + "', model = '" + model + "', price = " + price + " WHERE id=" + idm + ";";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("laptop with id " +idm+" updated" + "\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(Connection conn, int idm) {
        Statement statement;
        try {
            String query = "DELETE FROM laptops WHERE id="+idm+";";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("laptop with id " +idm+" deleted" + "\n");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
