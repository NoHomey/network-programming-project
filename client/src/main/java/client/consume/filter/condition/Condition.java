package client.consume.filter.condition;

import client.read.EventData;

public abstract class Condition {
    public Condition() {
        
    }

    public abstract boolean isTrue(EventData eventData);
}