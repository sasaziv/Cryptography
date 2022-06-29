package cryption;

import commonoperation.CharacterFrequency;
import commonoperation.SortMapBasedOnValues;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * We can use this method to crack the text of one author if we already have other text of the same author.
 * Base on the style of his writing (frequency of the letters in the text) we can decrypt the text we want to crack.
 */

public class StatisticalAnalysisCracker {

    List<String> textToGetFrequency;
    List<String> textToBeCrack;

    public StatisticalAnalysisCracker(List<String> textToGetFrequency, List<String> textToBeCrack) {
        this.textToGetFrequency = textToGetFrequency;
        this.textToBeCrack = textToBeCrack;
    }

    public List<String> crackTheText() {
        List<String> crackedText = new ArrayList<>();
        List<Character> inputFrequency = sortRelativeCharFrequency(textToGetFrequency);
        List<Character> textToBeCrackFrequency = sortRelativeCharFrequency(textToBeCrack);
        for (String string : textToBeCrack) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < string.length(); i++) {
                char ch = string.charAt(i);
                int number = textToBeCrackFrequency.indexOf(ch);
                if (number < inputFrequency.size()) {
                    sb.append(inputFrequency.get(number));
                } else {
                    sb.append(ch);
                }
            }
            crackedText.add(sb.toString());
        }
        return crackedText;
    }

    public List<Character> sortRelativeCharFrequency(List<String> textToGetFrequency) {

        Map<Character, Integer> absoluteFrequency = CharacterFrequency.getFrequency(textToGetFrequency);
        Map<Character, Double> relativeFrequency = CharacterFrequency.getRelativeFrequency(absoluteFrequency);
        SortMapBasedOnValues<Character, Double> sortMapBasedOnValues = new SortMapBasedOnValues<>(relativeFrequency);
        Map<Character, Double> sortedRelativeFrequency = sortMapBasedOnValues.sortByDescendingValue();
        return listOfCharacter(sortedRelativeFrequency);

    }

    private List<Character> listOfCharacter(Map<Character, Double> map) {
        List<Character> list = new ArrayList<>();
        for (Map.Entry<Character, Double> pair : map.entrySet()) {
            list.add(pair.getKey());
        }
        return list;
    }

}