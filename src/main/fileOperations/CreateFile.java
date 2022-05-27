package main.fileOperations;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void createFile(String filePath) {
        if (filePath.length() == 0) {
            System.out.println("You didn't enter a name. Try again.");
        } else {
            try {
                File myObj = new File("files/" + filePath);
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName() + ".");
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Something went wrong!");
            }
        }
    }
}
