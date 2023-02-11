import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        ConnectionUtil s = new ConnectionUtil();
        Connection con = s.connect_to_db("project", "postgres", "2222");
        s.createTable(con, "laptops");
        Scanner sc = new Scanner(System.in);
        int choice, chosenId;
        Laptop curLap = new Laptop();

        while (true){
            Menu.showMenu();
            choice = sc.nextInt();
            if (choice == 1){
                curLap = Menu.createLaptop();
                s.insert_row(con, curLap.getBrand(), curLap.getModel(), curLap.getPrice());
            }
            else if (choice == 2){
                s.showLaptops(con, "laptops");
            }
            else if (choice == 3){
                s.showLaptops(con, "laptops");
                chosenId = Menu.updateLaptop();
                curLap = Menu.createLaptop();
                s.update(con, chosenId, curLap.getBrand(), curLap.getModel(), curLap.getPrice());
            }
            else if (choice == 4){
                s.showLaptops(con, "laptops");
                chosenId = Menu.deleteLaptop();
                s.delete(con, chosenId);
            }
            else if (choice == 5){
                System.out.println("----------------");
                break;
            }
            else {
                System.out.println("Write correct number");
            }
        }

    }
}