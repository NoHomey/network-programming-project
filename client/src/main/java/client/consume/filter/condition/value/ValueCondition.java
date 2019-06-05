package client.consume.filter.condition.value;

import client.consume.filter.condition.Condition;
import client.consume.extract.Extractor;
import client.read.EventData;

public abstract class ValueCondition<V> extends Condition {
    protected final Extractor<V> extractor;

    public ValueCondition(Extractor<V> extractor) {
        super();
        this.extractor = extractor;
    }

    protected abstract boolean check(V value);

    @Override
    public final boolean isTrue(EventData eventData) {
        return check(extractor.extract(eventData));
    }
}