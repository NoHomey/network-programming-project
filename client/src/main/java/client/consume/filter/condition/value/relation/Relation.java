package client.consume.filter.condition.value.relation;

import client.consume.filter.condition.value.ValueCondition;
import client.consume.extract.Extractor;

public abstract class Relation<V> extends ValueCondition<V> {
    protected final V value;

    public Relation(Extractor<V> extractor, V value) throws IllegalArgumentException {
        super(extractor);
        if(value == null) {
            throw new IllegalArgumentException("value should not be null");
        }
        this.value = value;
    }

    protected abstract boolean relation(V value);

    @Override
    protected final boolean check(V value) {
        return value == null ? false : relation(value);
    }
}