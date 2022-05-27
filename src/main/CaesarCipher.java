package main;

import java.util.ArrayList;
import java.util.List;

public class CaesarCipher implements Encryption, Decryption {

    private int shift;
    private char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', ',', '.', '!', '?', ':', '-', '\"'};
//    private String letter = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";


    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    private int getCharIndex(char[] array, char character) {
        int counter = 0;
        for (char c : array) {
            if (c == character) {
                return counter;
            }
            counter++;
        }
        return -1;
    }


    @Override
    public String encode(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int numberOfCharacters = letters.length;
        for (int i = 0; i < string.length(); i++) {
//            int originalPosiotion = letter.indexOf(string.charAt(i));
            int originalPosiotion = getCharIndex(letters, string.charAt(i));
            if (originalPosiotion >= 0) {
                int newPosition = (originalPosiotion + shift) % numberOfCharacters;
//                char newChatecter = letter.charAt(newPosition);
                char newChatecter = letters[newPosition];
                stringBuilder.append(newChatecter);
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String decode(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int numberOfCharacters = letters.length;
        for (int i = 0; i < string.length(); i++) {
//            int originalPosiotion = letter.indexOf(string.charAt(i));
            int originalPosiotion = getCharIndex(letters, string.charAt(i));
            if (originalPosiotion >= shift) {
                int newPosition = originalPosiotion - shift;
//                char newChatecter = letter.charAt(newPosition);
                char newChatecter = letters[newPosition];
                stringBuilder.append(newChatecter);
            } else if (originalPosiotion < shift && originalPosiotion >= 0) {
                int newPosition = numberOfCharacters - (shift - originalPosiotion);
                char newChatecter = letters[newPosition];
                stringBuilder.append(newChatecter);
            }
        }
        return stringBuilder.toString();
    }

    public List<String> encodeFile(List<String> list) {
        List<String> encodedList = new ArrayList<>();
        for (String string : list) {
            encodedList.add(encode(string));
        }
        return encodedList;
    }

    public List<String> decodeFile(List<String> list) {
        List<String> encodedList = new ArrayList<>();
        for (String string : list) {
            encodedList.add(decode(string));
        }
        return encodedList;
    }
}
