package client.consume.extract;

import client.read.EventData;

public final class ExtractDescription extends Extractor<String> {
    private static final ExtractDescription instance = new ExtractDescription();

    public static Extractor<String> extractor() {
        return instance;
    }

    private ExtractDescription() {
        super();
    }

    @Override
    public final String extract(EventData eventData) {
        return eventData.valueForDescription();
    }
}