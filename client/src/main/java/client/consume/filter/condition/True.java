package client.consume.filter.condition;

import client.read.EventData;

public final class True extends Condition {
    public static True condition = new True();
    
    private True() {
        super();
    }

    @Override
    public final boolean isTrue(EventData eventData) {
        return true;
    }
}