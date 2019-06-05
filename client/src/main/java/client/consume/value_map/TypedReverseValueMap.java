package client.consume.value_map;

import java.util.HashMap;
import java.util.TreeMap;

public class TypedReverseValueMap<V> implements ReverseValueMap {
    private final TreeMap<Integer, V> map;

    public TypedReverseValueMap(HashMap<V, Integer> map) {
        this.map = new TreeMap<Integer, V>();
        map.forEach((key, value) -> this.map.put(value, key));
    }

    public V value(int index) {
        return map.get(index);
    }

    @Override
    public Object valueFromIndex(int index) {
        return value(index);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void clear() {
        map.clear();
    }
}