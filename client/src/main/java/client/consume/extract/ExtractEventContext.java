package client.consume.extract;

import client.read.EventData;

public final class ExtractEventContext extends Extractor<String> {
    private static final ExtractEventContext instance = new ExtractEventContext();

    public static Extractor<String> extractor() {
        return instance;
    }

    private ExtractEventContext() {
        super();
    }

    @Override
    public final String extract(EventData eventData) {
        return eventData.valueForEventContext();
    }
}