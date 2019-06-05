package client.consume.extract;

import client.read.EventData;

public final class ExtractEventUserID extends Extractor<Integer> {
    private static final ExtractEventUserID instance = new ExtractEventUserID();

    public static Extractor<Integer> extractor() {
        return instance;
    }

    private ExtractEventUserID() {
        super();
    }

    @Override
    public final Integer extract(EventData eventData) {
        return eventData.valueForEventUserID();
    }
}