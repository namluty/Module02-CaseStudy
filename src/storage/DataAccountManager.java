package storage;

import model.Account;
import model.Computer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccountManager {
    public static void writeFile(List<Account> accountList, String fileName){
        File file = new File(fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(accountList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Account> readFile(String fileName){
        List<Account> accounts = new ArrayList<>();
        File file = new File(fileName);
        if(file.length()>0){
            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                accounts = (List<Account>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return accounts;
    }
}

