package client.consume.filter.condition;

import client.read.EventData;

public final class Or extends Condition {
    private final Condition left;
    private final Condition right;

    public Or(Condition left, Condition right) {
        super();
        this.left = left;
        this.right = right;
    }

    @Override
    public final boolean isTrue(EventData eventData) {
        return left.isTrue(eventData) || right.isTrue(eventData);
    }
}