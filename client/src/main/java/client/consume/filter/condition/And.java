package client.consume.filter.condition;

import client.read.EventData;

public final class And extends Condition {
    private final Condition left;
    private final Condition right;

    public And(Condition left, Condition right) {
        super();
        this.left = left;
        this.right = right;
    }

    @Override
    public final boolean isTrue(EventData eventData) {
        return left.isTrue(eventData) && right.isTrue(eventData);
    }
}