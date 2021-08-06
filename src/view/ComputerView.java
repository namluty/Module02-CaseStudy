package view;

import controller.ComputerManager;
import model.Computer;
import storage.DataComputerManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComputerView {
    private List<Computer> computerList = DataComputerManager.readFile("computerList.txt");
    private ComputerManager admin = new ComputerManager("Admin", computerList);

    public void createNewComputer(ComputerManager computerManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name: ");
        String name = scanner.nextLine();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your input a id computer: ");
        int id = sc.nextInt();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your input a description of computer: ");
        String description = scan.nextLine();
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Enter your input a status of computer: ");
        String status = scan1.nextLine();
        Computer computer = new Computer(name,id,description, status);
        computerManager.addNewComputer(computer);
    }
    public void showAllComputer(ComputerManager computerManager) {
        System.out.println("List computer in Room Gamming:");
        System.out.println(computerList.size());
        for (Computer com : computerList) {
            System.out.println(com);
        }
    }

    public void editComputer(ComputerManager computerManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your input a name want to Edit: ");
        String search = scanner.nextLine();
        Computer name = computerManager.findByName(search);
        if (name == null)
            System.out.println("Not Found!");
        else {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Enter replace the old description: " + name.getDescription()); //Nhập mô tả mới thay thế mô tả cũ
            String newDecription = scanner1.nextLine();
            name.setDescription(newDecription);
        }
    }

    public void deleteComputer(ComputerManager computerManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your input a name want to Delete: ");
        String name = scanner.nextLine();
        Computer names = computerManager.findByName(name);
        if (names == null)
            System.out.println("Name does not exist");
        else {
            computerManager.deleteComputer(names);
        }
    }
    public List<Computer> computersOnline() {
        List<Computer> computers = new ArrayList<>();
        for (Computer computer : computerList) {
            if (computer.getStatus().equals("Avaiable")) {
                computers.add(computer);
            }
        }
        return computers;
    }

    public List<Computer> computersOffline() {
        List<Computer> computers = new ArrayList<>();
        for (Computer computer : computerList) {
            if (computer.getStatus().equals("Disable")) {
                computers.add(computer);
            }
        }
        return computers;
    }

    public void checkStatus() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name Computer want check status ");
        String name = scanner.nextLine();
        for (Computer status : computerList) {
            if (status.getName().equals(name)) {
                System.out.println(status.getStatus());
            }
        }
    }
}
