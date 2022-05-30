package main;

import main.fileOperations.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static List<String> lines;

    public static void main(String[] args) throws IOException {
        boolean endProgram = false;
        System.out.println("Hello! What would you like to do?");
        do {
            LanguageRules languageRules = new EnglishLanguage();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Choose number:");
            System.out.println("1. Create new file.");
            System.out.println("2. List all files.");
            System.out.println("3. Print file.");
            System.out.println("4. Encrypt file.");
            System.out.println("5. Decrypt file.");
            System.out.println("6. Brute force decrypt file.");
            System.out.println("7. Exit program.");

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
                int shiftWanted = caesarCipher.bruteForce(lines);
                System.out.println("most probably shift is: " + shiftWanted);
            } else if (numberPick == 7) {
                endProgram = true;
            } else {
                bufferedReader.close();
                System.out.println("You didn't enter expected number");
            }
        }
        while (!endProgram);

    }
}
