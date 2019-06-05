package client.consume.extract;

import client.read.EventData;

public final class ExtractEventContextKind extends Extractor<String> {
    private static final ExtractEventContextKind instance = new ExtractEventContextKind();

    public static Extractor<String> extractor() {
        return instance;
    }

    private ExtractEventContextKind() {
        super();
    }

    @Override
    public final String extract(EventData eventData) {
        return eventData.valueForEventContextKind();
    }
}