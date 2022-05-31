package main.fileOperations;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListAllFiles {
    public static final String PATHTOFILES = "files/";

    File[] files = new File(PATHTOFILES).listFiles();

    public void printList() {
        System.out.println("File list:");
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }

}
