package main.fileOperations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFile {

    private static List<String> list;

    public static List<String> readFromFile(String filePath) {
        filePath = "files/" + filePath;
        try {
            list = Files.readAllLines(Paths.get(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}