package commonoperation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TO DO

public class CharacterFrequency {
    //    List<String> list = new ArrayList<>();
    List<String> list;

    public CharacterFrequency(List<String> list) {
        this.list = list;
    }

    /**
     * Method for getting absolute frequency of characters
     */
    public static Map<Character, Integer> getFrequency(List<String> list) {
        Map<Character, Integer> map = new HashMap<>();
        for (String string : list) {
            for (int i = 0; i < string.length(); i++) {
                char ch = string.charAt(i);
                if (!map.containsKey(ch)) {
                    map.put(ch, 1);
                } else {
                    int keyValue = map.get(ch);
                    map.replace(ch, ++keyValue);
                }
            }
        }
        return map;
    }

    /**
     * Method for getting relative frequency of characters
     */
    public static Map<Character, Double> getRelativeFrequency(Map<Character, Integer> map) {
        int sum = map.values().stream().mapToInt(Integer::intValue).sum();
        Map<Character, Double> relativeMap = new HashMap<>();
        for (Map.Entry<Character, Integer> pair : map.entrySet()) {
            double value = pair.getValue();
            double relativeFrequency = value / sum;
            char key = pair.getKey();
            relativeMap.put(key, relativeFrequency);
        }
        return relativeMap;
    }

}
