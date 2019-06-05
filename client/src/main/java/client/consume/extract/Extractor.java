package client.consume.extract;

import client.read.EventData;

public abstract class Extractor<V> {
    protected Extractor() {
        
    }

    public abstract V extract(EventData eventData);
};