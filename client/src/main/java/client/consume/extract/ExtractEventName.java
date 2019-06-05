package client.consume.extract;

import client.read.EventData;

public final class ExtractEventName extends Extractor<String> {
    private static final ExtractEventName instance = new ExtractEventName();

    public static Extractor<String> extractor() {
        return instance;
    }

    private ExtractEventName() {
        super();
    }

    @Override
    public final String extract(EventData eventData) {
        return eventData.valueForEventName();
    }
}