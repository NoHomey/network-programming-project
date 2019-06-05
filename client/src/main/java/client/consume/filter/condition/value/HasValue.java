package client.consume.filter.condition.value;

import client.consume.extract.Extractor;

public final class HasValue<V> extends ValueCondition<V> {
    public HasValue(Extractor<V> extractor) {
        super(extractor);
    }

    @Override
    protected final boolean check(V value) {
        return value != null;
    }
}