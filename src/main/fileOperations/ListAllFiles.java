package main.fileOperations;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListAllFiles {
    String pathToFiles = "files";

    File[] files = new File(pathToFiles).listFiles();

    public void printList() {
        System.out.println("File list:");
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }

}
