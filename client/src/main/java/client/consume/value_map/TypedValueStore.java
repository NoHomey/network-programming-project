package client.consume.value_map;

import java.util.HashMap;

import client.consume.extract.Extractor;
import client.read.EventData;

public class TypedValueStore<V> implements ValueStore {
    private final HashMap<V, Integer> map;
    private int index;
    private final Extractor<V> extractor;

    public TypedValueStore(Extractor<V> extractor) {
        map = new HashMap<V, Integer>();
        index = 0;
        this.extractor = extractor;
    }

    @Override
    public void storeValue(EventData eventData) {
        final V value = extractor.extract(eventData);
        if((value != null) && (!map.containsKey(value))) {
            map.put(value, index);
            ++index;
        }
    }

    @Override
    public ValueMap valueMap(int start) {
        map.replaceAll((key, value) -> value + start);
        return new TypedValueMap<V>(extractor, map);
    }
}