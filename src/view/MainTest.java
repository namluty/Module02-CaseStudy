package view;

import controller.AccountManager;
import controller.ComputerManager;

import java.util.Scanner;

public class MainTest {
    static ComputerView computerView = new ComputerView();
    static AccountView accountView = new AccountView();

    public static void main(String[] args) {
        login();
        System.out.println("Next Step!!!");
        showMenuComputer();
        showMenuAccount();
    }

    public static void showMenuComputer() {
        ComputerManager manager = new ComputerManager();
        Scanner input = new Scanner(System.in);
        int choose = -1;

        while (choose != 0) {
            System.out.println("Menu");
            System.out.println("1. Creat a computer in Room Gamming: ");
            System.out.println("2. Display list computer in Room Gamming: ");
            System.out.println("3. Edit a computer in Room Gamming: ");
            System.out.println("4. Delete a computer in Room Gamming: ");
            System.out.println("5. Check Status: ");
            System.out.println("0. Exit!!!: ");
            System.out.println("Enter your choose: ");
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    computerView.createNewComputer(manager);
                    break;
                case 2:
                    computerView.showAllComputer(manager);
                    break;
                case 3:
                    computerView.editComputer(manager);
                    break;
                case 4:
                    computerView.deleteComputer(manager);
                    break;
                case 5:
                    computerView.checkStatus();
                    break;
                case 0:
                    System.out.println("Exit Menu!!!");
                default:
                    System.out.println("See You Again");
            }
        }
    }

    public static void showMenuAccount() {
        AccountManager managers = new AccountManager();
        Scanner input1 = new Scanner(System.in);
        int choose = -1;

        while (choose != 0) {
            System.out.println("Menu");
            System.out.println("1. Creat a account: ");
            System.out.println("2. Display list account: ");
            System.out.println("3. Edit a account: ");
            System.out.println("4. Delete a account: ");
            System.out.println("0. Exit!!!: ");
            System.out.println("Enter your choose: ");
            choose = input1.nextInt();
            switch (choose) {
                case 1:
                    AccountView.createNewAccount(managers);
                    break;
                case 2:
                    AccountView.showAllAccount(managers);
                    break;
                case 3:
                    accountView.editAccount(managers);
                    break;
                case 4:
                    AccountView.deleteAcccount(managers);
                    break;
                case 0:
                    System.out.println("Exit Menu!!!");
                default:
                    System.out.println("See You Again");
            }
        }
    }

    static void login() {
        Scanner scan1 = new Scanner(System.in);
        System.out.println("---WELCOME TO NAMLUTY GAMMING---");
        System.out.println("User Name: ");
        String username = scan1.nextLine();

        System.out.println("Passwords: ");
        String password = scan1.nextLine();

        if(username.equalsIgnoreCase("namluty") && password.equals("nam123")) {
            System.out.println("Login Success!!!");
        } else {
            System.err.println("Login Failed - Please Re-Login");
            login();
        }
    }
}




