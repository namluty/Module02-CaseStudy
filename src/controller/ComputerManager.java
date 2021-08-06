package controller;

import model.Computer;
import storage.DataComputerManager;

import java.util.List;

public class ComputerManager {
    private String name;
    private static List<Computer> computerList;

    public ComputerManager() {
    }

    public ComputerManager(String name, List<Computer> computerList) {
        this.name = name;
        ComputerManager.computerList = computerList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Computer> getComputerList() {
        return computerList;
    }

    public static void setComputerList(List<Computer> computerList) {
            ComputerManager.computerList = computerList;
    }

    public void addNewComputer(Computer computer) {
        computerList.add(computer);
        DataComputerManager.writeFile(computerList, "computerList.txt");
    }
    public Computer findByName(String name) {
        Computer computer = null;
        for (Computer com : computerList
        ) {
            if (com.getName().equals(name))
                computer = com;
        }
        return computer;
    }
    public void deleteComputer(Computer computer) {
        computerList.remove(computer);
        DataComputerManager.writeFile(computerList, "computerList.txt");
    }
}
