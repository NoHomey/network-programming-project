package client.consume.extract;

import client.read.EventData;

public final class ExtractResourceName extends Extractor<String> {
    private static final ExtractResourceName instance = new ExtractResourceName();

    public static Extractor<String> extractor() {
        return instance;
    }

    private ExtractResourceName() {
        super();
    }

    @Override
    public final String extract(EventData eventData) {
        return eventData.valueForResourceName();
    }
}