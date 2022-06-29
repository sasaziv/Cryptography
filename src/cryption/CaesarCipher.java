package cryption;

import languages.LanguageRules;

import java.util.ArrayList;
import java.util.List;

/**
 * CaesarCipher is a class for encryption/decryption. Based on a character list we can rotate(shift) each letter by the number user enter.
 */

public class CaesarCipher {

    private int shift;

    LanguageRules languageRules;

    List<Character> characters;

    public CaesarCipher(int shift, LanguageRules languageRules) {
        this.shift = shift;
        this.languageRules = languageRules;
        characters = languageRules.getCharacters();
    }

    /**
     * Shift string by +"shift" in constructor
     */
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

    /**
     * Shift string by -"shift" in constructor
     */
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

    /**
     * Shift every string in list by encode method
     */
    public List<String> encodeFile(List<String> list) {
        List<String> encodedList = new ArrayList<>();
        for (String string : list) {
            encodedList.add(encode(string));
        }
        return encodedList;
    }

    /**
     * Shift every string in list by decode method
     */
    public List<String> decodeFile(List<String> list) {
        List<String> encodedList = new ArrayList<>();
        for (String string : list) {
            encodedList.add(decode(string));
        }
        return encodedList;
    }
}
