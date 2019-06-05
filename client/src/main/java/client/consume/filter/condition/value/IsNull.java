package client.consume.filter.condition.value;

import client.consume.extract.Extractor;

public final class IsNull<V> extends ValueCondition<V> {
    public IsNull(Extractor<V> extractor) {
        super(extractor);
    }

    @Override
    protected final boolean check(V value) {
        return value == null;
    }
}