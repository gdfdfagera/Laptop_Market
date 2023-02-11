import java.util.Scanner;
public class Menu {

    static void showMenu() {
        System.out.println("1.Add new laptop" );
        System.out.println("2.Show all laptops" );
        System.out.println("3.Update laptop" );
        System.out.println("4.Delete laptop" );
        System.out.println("5.Quit" );
    }

    static Laptop createLaptop() {
        int n;
        Scanner sc = new Scanner(System.in);
        String str;
        Double dbl;
        Laptop lap = new Laptop();

        System.out.println("Write the brand");
        str = sc.next();
        lap.setBrand(str);

        System.out.println("Write the model");
        str = sc.next();
        lap.setModel(str);

        System.out.println("Write the price");
        dbl = sc.nextDouble();
        lap.setPrice(dbl);
        return lap;
    }

    static int updateLaptop(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write the ID of the laptop you would like to change");
        int n = sc.nextInt();
        return n;
    }

    static int deleteLaptop(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write the ID of the laptop you would like to delete");
        int n = sc.nextInt();
        return n;
    }
}
