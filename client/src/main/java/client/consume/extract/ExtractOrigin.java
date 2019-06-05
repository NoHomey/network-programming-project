package client.consume.extract;

import client.read.EventData;

public final class ExtractOrigin extends Extractor<String> {
    private static final ExtractOrigin instance = new ExtractOrigin();

    public static Extractor<String> extractor() {
        return instance;
    }

    private ExtractOrigin() {
        super();
    }

    @Override
    public final String extract(EventData eventData) {
        return eventData.valueForOrigin();
    }
}