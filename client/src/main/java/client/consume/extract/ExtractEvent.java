package client.consume.extract;

import client.read.EventData;

public final class ExtractEvent extends Extractor<String> {
    private static final ExtractEvent instance = new ExtractEvent();

    public static Extractor<String> extractor() {
        return instance;
    }

    private ExtractEvent() {
        super();
    }

    @Override
    public final String extract(EventData eventData) {
        return eventData.valueForEvent();
    }
}