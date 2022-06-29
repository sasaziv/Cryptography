package commonoperation;


import java.util.*;
import java.util.Map.Entry;
import java.util.Collections;
import java.util.Comparator;

public class SortMapBasedOnValues<K extends Comparable<K>, V extends Comparable<V>> {
    Map<K, V> map;

    public SortMapBasedOnValues(Map<K, V> map) {
        this.map = map;
    }

    public LinkedHashMap<K, V> sortByDescendingValue() {
        List<Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Entry<K, V>>() {
            @Override
            public int compare(Entry<K, V> o1, Entry<K, V> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        LinkedHashMap<K, V> sortedMap = new LinkedHashMap<K, V>();
        for (Entry<K, V> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
