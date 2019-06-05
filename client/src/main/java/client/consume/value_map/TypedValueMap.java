package client.consume.value_map;

import java.util.HashMap;

import client.consume.extract.Extractor;
import client.read.EventData;

public class TypedValueMap<V> implements ValueMap {
    private final HashMap<V, Integer> map;
    private final Extractor<V> extractor;

    public TypedValueMap(Extractor<V> extractor, HashMap<V, Integer> store) {
        map = store;
        this.extractor = extractor;
    }

    @Override
    public Integer mapValue(EventData eventData) {
        final V value = extractor.extract(eventData);
        return map.get(value);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public ReverseValueMap reverseValueMap() {
        return new TypedReverseValueMap<V>(map);
    }
}