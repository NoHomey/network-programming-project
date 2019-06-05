package client.consume.filter.condition;

import client.read.EventData;

public final class Not extends Condition {
    private final Condition condition;

    public Not(Condition condition) {
        super();
        this.condition = condition;
    }

    @Override
    public final boolean isTrue(EventData eventData) {
        return !(condition.isTrue(eventData));
    }
}