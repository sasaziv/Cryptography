package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CaesarCipher implements Encryption, Decryption {

    private int shift;

    LanguageRules languageRules;

    List<Character> characters;

//    List<Character> characters = new LinkedList<>(List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', ',', '.', '!', '?', ':', '-', '\"'));

    public CaesarCipher(int shift, LanguageRules languageRules) {
        this.shift = shift;
        this.languageRules = languageRules;
        characters = languageRules.getAllCharacters();
    }

    // Shift string by +"shift" in constructor
    public String encode(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (characters.contains(ch)) {
                int originalPosition = characters.indexOf(ch);
                int newPosition = (originalPosition + shift) % characters.size();
                char newChar = characters.get(newPosition);
                stringBuilder.append(newChar);
            }
        }
        return stringBuilder.toString();
    }

    //Shift string by -"shift" in constructor
    public String decode(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (characters.contains(ch)) {
                int originalPosition = characters.indexOf(ch);
                int newPosition = (originalPosition - shift) % characters.size();
                if (newPosition < 0) {
                    newPosition = characters.size() + newPosition;
                }
                char newChar = characters.get(newPosition);
                stringBuilder.append(newChar);
            }
        }
        return stringBuilder.toString();
    }

    //    Shift every string in list by +"shift" in constructor
    public List<String> encodeFile(List<String> list) {
        List<String> encodedList = new ArrayList<>();
        for (String string : list) {
            encodedList.add(encode(string));
        }
        return encodedList;
    }

    //    Shift every string in list by -"shift" in constructor
    public List<String> decodeFile(List<String> list) {
        List<String> encodedList = new ArrayList<>();
        for (String string : list) {
            encodedList.add(decode(string));
        }
        return encodedList;
    }

    //Shift string by -parameter in method
    public String decode(String string, int shift) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (characters.contains(ch)) {
                int originalPosition = characters.indexOf(ch);
                int newPosition = (originalPosition - shift) % characters.size();
                if (newPosition < 0) {
                    newPosition = characters.size() + newPosition;
                }
                char newChar = characters.get(newPosition);
                stringBuilder.append(newChar);
            }
        }
        return stringBuilder.toString();
    }

    //Shift list of string by -parameter in method
    public List<String> decodeFile(List<String> list, int i) {
        List<String> encodedList = new ArrayList<>();
        for (String string : list) {
            encodedList.add(decode(string, i));
        }
        return encodedList;
    }

    // Brute force fot getting most probably shift
    public int bruteForce(List<String> listInput) {
        ArrayList<Double> decryptionValue = new ArrayList<>();
        for (int i = 0; i < characters.size(); i++) {
            List<String> list = decodeFile(listInput, i);
            decryptionValue.add(i, languageRules.bruteForce(list));
        }
        double maxScore = decryptionValue.get(0);
        for (double score : decryptionValue) {
            if (score > maxScore) {
                maxScore = score;
            }
        }
        return decryptionValue.indexOf(maxScore);
    }
}
