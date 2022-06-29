package languages;

import fileoperations.ReadCharacters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EnglishLanguage implements LanguageRules {

    private final List<Character> characters;
    private final List<String> mostCommonWordsInEnglish;
    private final List<String> nonexistentCharacterStrings;

    public EnglishLanguage() {
        this.characters = getAllCharacters();
        this.mostCommonWordsInEnglish = mostCommonWordsInEnglish();
        this.nonexistentCharacterStrings = nonexistentCharacterStrings();
    }

    public List<Character> getCharacters() {
        return characters;
    }

    /**
     * Reading characters from configurationfiles/english.txt
     */

    public List<Character> getAllCharacters() {
        String character = "characters:";
        List<Character> characterList = new ArrayList<>();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("configurationfiles/english.txt"));
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (line.startsWith(character)) {
                    line = line.substring(character.length()).trim();
                    characterList = ReadCharacters.getListOfCharactersFromString(line);
                    return characterList;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characterList;
    }

    /**
     * Reading most common words in English from configurationfiles/english.txt
     */
    private List<String> mostCommonWordsInEnglish() {
        List<String> mostCommonWordsInEnglish = new ArrayList<>();
        String mostCommonWords = "mostcommonwords:";
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("configurationfiles/english.txt"));
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (line.startsWith(mostCommonWords)) {
                    line = line.substring(mostCommonWords.length()).trim();
                    mostCommonWordsInEnglish = ReadCharacters.getListOfCharactersCombinationFromString(line);
                    break;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mostCommonWordsInEnglish;
    }

    /**
     * Reading most non-existing words in English from configurationfiles/english.txt
     */
    private List<String> nonexistentCharacterStrings() {
        String nonexistent = "nonexistent:";
        List<String> nonexistentCharacterStrings = new ArrayList<>();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("configurationfiles/english.txt"));
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (line.startsWith(nonexistent)) {
                    line = line.substring(nonexistent.length()).trim();
                    nonexistentCharacterStrings = ReadCharacters.getListOfCharactersCombinationFromString(line);
                    break;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nonexistentCharacterStrings;
    }

    /**
     * Getting the value of brute force for list
     */
    @Override
    public double bruteForce(List<String> list) {
        double result = 0;
        for (String string : list) {
            result += bruteForce(string);
        }
        return result;
    }

    /**
     * Getting the value of brute force for string
     */
    @Override
    public double bruteForce(String textline) {

        double resultOfTestingWords = containsWord(textline);
        double resultOfTestingSimpleGrammer = mostCommonRulesInEnglish(textline);

        return resultOfTestingWords + resultOfTestingSimpleGrammer;
    }

    /**
     * Testing on simple grammar rules. Sentence start with big letter. Space after dot, comma....
     */
    private double mostCommonRulesInEnglish(String textline) {
        double result = 0.0;
        char currentChar;
        char nextChar;
        int countOfDoubleQuotes = 0;
        for (int i = 0; i < textline.length() - 1; i++) {
            currentChar = textline.charAt(i);
            nextChar = textline.charAt(i + 1);
            if (currentChar == '.' && nextChar == ' ' || currentChar == '.' && nextChar == '.') {
                result += 0.5;
            }
            if (currentChar == '!' || currentChar == '?' || currentChar == ',' || currentChar == ':') {
                result += 0.5;
            }
            if (currentChar == '\"') {
                countOfDoubleQuotes++;
            }
        }
        if (countOfDoubleQuotes % 2 == 0) {
            result += 2;
        }
        return result;
    }


    /**
     * Testing for most common words and non-existing pairs of chars in English language.
     */
    private double containsWord(String textLine) {
        double result = 0.0;
        textLine = textLine.toLowerCase();

        for (String word : mostCommonWordsInEnglish) {
            if (textLine.contains(word)) {
                result++;
            }
        }
        for (String word : nonexistentCharacterStrings) {
            if (textLine.contains(word)) {
                result -= 2;
            }
        }
        return result;
    }

}