package main.fileOperations;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public abstract class WriteToFile {

    public static void writeAll(List<String> lines, String filePath) {
        filePath = "files/" + filePath;
        try {
            Path path = Path.of(filePath);
            Files.write(path, lines);
            System.out.println("Changes have been successfully saved!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something went wrong! Your changes have not been saved.");
        }
    }

}
