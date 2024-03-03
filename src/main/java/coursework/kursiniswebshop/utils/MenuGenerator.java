package coursework.kursiniswebshop.utils;

import coursework.kursiniswebshop.model.Manager;
import coursework.kursiniswebshop.model.Product;
import coursework.kursiniswebshop.model.User;

import java.util.List;
import java.util.Scanner;

public class MenuGenerator {
    public static void generateProductMenu(Scanner scanner, List<Product> systemProducts) {
        var productMenuCmd = 0;

        while (productMenuCmd != 6) {
            System.out.println("""
                    --------------------
                    Choose an action:
                    1 - create product
                    2 - view all products
                    3 - update product
                    4 - delete product
                    5 - view specific product
                    6 - quit
                    --------------------""");

            productMenuCmd = scanner.nextInt();
            scanner.nextLine();

            switch (productMenuCmd) {
                case 1:
                    System.out.println("Which type of product? G (Game) / S (Software) / Sb (Subscription)");
                    String response = scanner.nextLine();
                    //Cia galima su (1) if-else susidelioti, (2) galima dar viena switch, (3) galima iskelti i dar atskira metoda
                    //Paimsiu (2) + (3)

//                    if (response.equals("C")) {
//                        System.out.println("Enter data in format like this login;psw;name;surname;cardNo;shipA;billA;b-date;");
//                        response = scanner.nextLine();
//                        String[] info = response.split(";");
//                        Customer customer = new Customer(info[0], info[1], info[2], info[3], info[4], info[5], info[6], LocalDate.parse(info[7]));
//                        systemUsers.add(customer);
//                    } else if (response.equals("M")) {
//
//
//                    } else {
//                        System.out.println("Wrong user type\n");
//                    }
                    break;
                default:
                    System.out.println("Wrong commmand!");
            }
        }
    }
    public static void generateUserMenu(Scanner scanner, List<User> systemUsers) {
        var userMenuCmd = 0;

        while (userMenuCmd != 6) {
            System.out.println("""
                    --------------------
                    Choose an action:
                    1 - create User
                    2 - view all users
                    3 - update user
                    4 - delete user
                    5 - view specific user
                    6 - quit
                    --------------------""");

            userMenuCmd = scanner.nextInt();
            scanner.nextLine();

            switch (userMenuCmd){
                case 1:
                    System.out.println("Which type of user? C/M");
                    var response = "";
                    response = scanner.nextLine();
                    if(response.equals("C")){

                    } else if (response.equals("M")) {
                        System.out.println("Enter manager data: name;surname;login;psw;isAdmin;");
                        response = scanner.nextLine();
                        String[] info = response.split(";");
                        Manager manager = new Manager(info[0], info[1], info[2], info[3], Boolean.parseBoolean(info[4]));
                        systemUsers.add(manager);
                        System.out.println(manager);
                    } else {
                        System.out.println("Wrong user type\n");
                    }
                    break;
                default:
                    System.out.println("Wrong command");
            }
        }
    }
}
