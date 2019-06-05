package client.consume.extract;

import client.read.EventData;

public final class ExtractDate extends Extractor<String> {
    private static final ExtractDate instance = new ExtractDate();

    public static Extractor<String> extractor() {
        return instance;
    }

    private ExtractDate() {
        super();
    }

    @Override
    public final String extract(EventData eventData) {
        return eventData.valueForDate();
    }
}