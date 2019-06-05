package client.consume.extract;

import client.read.EventData;

public final class ExtractEventID extends Extractor<Integer> {
    private static final ExtractEventID instance = new ExtractEventID();

    public static Extractor<Integer> extractor() {
        return instance;
    }

    private ExtractEventID() {
        super();
    }

    @Override
    public final Integer extract(EventData eventData) {
        return eventData.valueForEventID();
    }
}