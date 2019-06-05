package client.consume.filter.condition.value.relation;

import client.consume.extract.Extractor;

public final class GreaterThanOrEqualToValue<V extends Comparable<V>> extends Relation<V> {
    public GreaterThanOrEqualToValue(Extractor<V> extractor, V value) throws IllegalArgumentException {
        super(extractor, value);
    }

    @Override
    protected final boolean relation(V value) {
        return value.compareTo(this.value) >= 0;
    }
}