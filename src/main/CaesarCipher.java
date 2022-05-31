package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// CaesarCipher is a class for encryption/decryption where each letter is replaced by another letter.
// when creating an object we have to enter the number of places for which the characters will rotate as well as which language is in question.

public class CaesarCipher implements Encryption, Decryption {

    private int shift;

    LanguageRules languageRules;

    List<Character> characters;

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

    //    Shift every string in list by encode method
    public List<String> encodeFile(List<String> list) {
        List<String> encodedList = new ArrayList<>();
        for (String string : list) {
            encodedList.add(encode(string));
        }
        return encodedList;
    }

    //    Shift every string in list by decode method
    public List<String> decodeFile(List<String> list) {
        List<String> encodedList = new ArrayList<>();
        for (String string : list) {
            encodedList.add(decode(string));
        }
        return encodedList;
    }


    // Brute force fot getting most probably shift
    public int bruteForce(List<String> listInput, LanguageRules languageRules) {
        ArrayList<Double> decryptionValue = new ArrayList<>();
        for (int i = 0; i < characters.size(); i++) {
            CaesarCipher caesarCipher = new CaesarCipher(i, languageRules);
            List<String> list = caesarCipher.decodeFile(listInput);
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
