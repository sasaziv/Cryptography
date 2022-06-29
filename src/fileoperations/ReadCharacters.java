package fileoperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadCharacters {

    /** With method getListOfCharactersFromString we are creating list of characters from string using nothing as delimiter */
    public static List<Character> getListOfCharactersFromString(String string) {
        List<Character> listOfCharacters = new ArrayList<>();
        Scanner scan = new Scanner(string);
        scan.useDelimiter("");
        while (scan.hasNext()) {
            String s = scan.next();
            listOfCharacters.add(s.charAt(0));
        }
        scan.close();
        return listOfCharacters;
    }


    /** With method getListOfCharactersCombinationFromString we are creating list of strings from string using "," as delimiter */
    public static List<String> getListOfCharactersCombinationFromString(String string) {
        List<String> listOfStrings = new ArrayList<>();
        Scanner scan = new Scanner(string);
        scan.useDelimiter(",");
        while (scan.hasNext()) {
            String s = scan.next();
            listOfStrings.add(s);
        }
        scan.close();
        return listOfStrings;
    }
}
