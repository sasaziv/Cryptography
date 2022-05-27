package main.fileOperations;

import java.io.*;

public class PrintFromFile {
    public static void printAll(String pathFile) {
        pathFile = "files/" + pathFile;
        File f = new File(pathFile);
        System.out.println(f.getName() + " content:");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}