package client.consume.filter.condition.value.relation;

import client.consume.extract.Extractor;

public final class NotEqualToValue<V> extends Relation<V> {
    public NotEqualToValue(Extractor<V> extractor, V value) throws IllegalArgumentException {
        super(extractor, value);
    }

    @Override
    protected final boolean relation(V value) {
        return !this.value.equals(value);
    }
}