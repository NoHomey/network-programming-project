package client.consume.filter.condition.value;

import java.util.TreeSet;

import client.consume.extract.Extractor;

public final class ValueInList<V> extends ValueCondition<V> {
    private final TreeSet<V> values;

    public ValueInList(Extractor<V> extractor, V[] list) throws IllegalArgumentException {
        super(extractor);
        if(list == null) {
            throw new IllegalArgumentException("list should not be null");
        }
        values = new TreeSet<V>();
        for(V value: list) {
            if(value == null) {
                throw new IllegalArgumentException("values in list should not be null");
            }
            values.add(value);
        }
    }

    @Override
    protected final boolean check(V value) {
        return value == null ? false : values.contains(value);
    }
}