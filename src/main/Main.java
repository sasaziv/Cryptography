package main;

import main.fileOperations.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.List;

public class Main {
    public static List<String> lines;

    public static void main(String[] args) {
        boolean endProgram = false;
        System.out.println("Hello! What would you like to do?");
        do {
            LanguageRules languageRules = new EnglishLanguage();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Choose number:");
            System.out.println("1. Create new file.");
            System.out.println("2. List all files.");
            System.out.println("3. Print file.");
            System.out.println("4. Caesar encrypt file.");
            System.out.println("5. Caesar decrypt file.");
            System.out.println("6. Brute force decrypt file.");
            System.out.println("7. Statistical analysis decrypt file.");
            System.out.println("8. Exit program.");
            try {
                int numberPick = Integer.parseInt(bufferedReader.readLine().trim());
                if (numberPick == 1) {
                    System.out.println("Enter file name:");
                    String fileName = bufferedReader.readLine().trim();
                    CreateFile.createFile(fileName);
                } else if (numberPick == 2) {
                    ListAllFiles listAllFiles = new ListAllFiles();
                    listAllFiles.printList();
                } else if (numberPick == 3) {
                    System.out.println("Enter file name:");
                    String fileName = bufferedReader.readLine();
                    PrintFromFile.printAll(fileName);
                } else if (numberPick == 4) {
                    System.out.println("Enter file name:");
                    String fileName = bufferedReader.readLine();
                    lines = ReadFile.readFromFile(fileName);
                    System.out.println("Enter number to shift:");
                    int numberToShift = Integer.parseInt(bufferedReader.readLine().trim());
                    CaesarCipher caesarCipher = new CaesarCipher(numberToShift, languageRules);
                    lines = caesarCipher.encodeFile(lines);
                    System.out.println("Enter file name to be saved:");
                    String saveToFileName = bufferedReader.readLine();
                    WriteToFile.writeAll(lines, saveToFileName);
                } else if (numberPick == 5) {
                    System.out.println("Enter file name:");
                    String fileName = bufferedReader.readLine();
                    lines = ReadFile.readFromFile(fileName);
                    System.out.println("Enter number to shift:");
                    int numberToShift = Integer.parseInt(bufferedReader.readLine().trim());
                    CaesarCipher caesarCipher = new CaesarCipher(numberToShift, languageRules);
                    lines = caesarCipher.decodeFile(lines);
                    System.out.println("Enter file name to be saved:");
                    String saveToFileName = bufferedReader.readLine();
                    WriteToFile.writeAll(lines, saveToFileName);
                } else if (numberPick == 6) {
                    System.out.println("Enter file name:");
                    String fileName = bufferedReader.readLine();
                    lines = ReadFile.readFromFile(fileName);
                    CaesarCipher caesarCipher = new CaesarCipher(0, languageRules);
                    int shiftWanted = caesarCipher.bruteForce(lines, languageRules);
                    System.out.println("most probably shift is: " + shiftWanted);
                } else if (numberPick == 7) {
                    // TO DO
                    System.out.println("Statistical analysis need to be implemented.");
                } else if (numberPick == 8) {
                    endProgram = true;
                    bufferedReader.close();
                } else {
                    System.out.println("You didn't enter expected number");
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        while (!endProgram);
    }
}
