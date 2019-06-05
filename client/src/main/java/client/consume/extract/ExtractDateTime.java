package client.consume.extract;

import client.read.EventData;

public final class ExtractDateTime extends Extractor<String> {
    private static final ExtractDateTime instance = new ExtractDateTime();

    public static Extractor<String> extractor() {
        return instance;
    }

    private ExtractDateTime() {
        super();
    }

    @Override
    public final String extract(EventData eventData) {
        return eventData.valueForDateTime();
    }
}