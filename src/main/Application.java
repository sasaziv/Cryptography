package main;

import cryption.BruteForceCracker;
import cryption.CaesarCipher;
import cryption.StatisticalAnalysisCracker;
import fileoperations.*;
import languages.EnglishLanguage;
import languages.LanguageRules;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Application {
    public static List<String> lines;

    public static void run() {
        boolean endProgram = false;
        LanguageRules languageRules = new EnglishLanguage();
        System.out.println("Hello! What would you like to do?");
        do {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Choose number:");
            System.out.println("1. Create new file.");
            System.out.println("2. List all files.");
            System.out.println("3. Print file.");
            System.out.println("4. Caesar encrypt file.");
            System.out.println("5. Brute force decrypt file.");
            System.out.println("6. Statistical analysis decrypt file.");
            System.out.println("7. Exit program.");
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
                    if (ListAllFiles.fileExist(fileName)) {
                        PrintFromFile.printAll(fileName);
                    } else {
                        System.out.println("File doesn't exist!");
                        continue;
                    }
                } else if (numberPick == 4) {
                    System.out.println("Enter file name:");
                    String fileName = bufferedReader.readLine();
                    if (ListAllFiles.fileExist(fileName)) {
                        lines = ReadFile.readFromFile(fileName);
                    } else {
                        System.out.println("File doesn't exist!");
                        continue;
                    }
                    System.out.println("Enter number to shift:");
                    int numberToShift = Integer.parseInt(bufferedReader.readLine().trim());
                    if (numberToShift < 0) {
                        System.out.println("Number to shift can't be negative value.");
                        continue;
                    }
                    CaesarCipher caesarCipher = new CaesarCipher(numberToShift, languageRules);
                    lines = caesarCipher.encodeFile(lines);
                    System.out.println("Enter file name to be saved:");
                    String saveToFileName = bufferedReader.readLine();
                    WriteToFile.writeAll(lines, saveToFileName);
                } else if (numberPick == 5) {
                    System.out.println("Enter file name:");
                    String fileName = bufferedReader.readLine();
                    if (ListAllFiles.fileExist(fileName)) {
                        lines = ReadFile.readFromFile(fileName);
                    } else {
                        System.out.println("File doesn't exist!");
                        continue;
                    }
                    BruteForceCracker bruteForceCracker = new BruteForceCracker(languageRules);
                    int shiftWanted = bruteForceCracker.bruteForce(lines, languageRules);
                    System.out.println("Most probably shift is: " + shiftWanted + "\n-----");
                    System.out.println("Decrypted text:\n-----");
                    CaesarCipher caesarCipher = new CaesarCipher(shiftWanted, languageRules);
                    List<String> crackedLines = caesarCipher.decodeFile(lines);
                    for (String string : crackedLines) {
                        System.out.println(string);
                    }
                } else if (numberPick == 6) {
                    System.out.println("Enter file name to be decrypt:");
                    String fileName = bufferedReader.readLine();
                    if (ListAllFiles.fileExist(fileName)) {
                        lines = ReadFile.readFromFile(fileName);
                    } else {
                        System.out.println("File doesn't exist!");
                        continue;
                    }
                    System.out.println("Enter file name to get statistics:");
                    List<String> textFotStatistic;
                    String fileName2 = bufferedReader.readLine();
                    if (ListAllFiles.fileExist(fileName2)) {
                        textFotStatistic = ReadFile.readFromFile(fileName2);
                    } else {
                        System.out.println("File doesn't exist!");
                        continue;
                    }
                    StatisticalAnalysisCracker cracker = new StatisticalAnalysisCracker(textFotStatistic, lines);
                    List<String> list3 = cracker.crackTheText();
                    System.out.println("Text:\n-----");
                    for (String string: list3) {
                        System.out.println(string);
                    }
                } else if (numberPick == 7) {
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
