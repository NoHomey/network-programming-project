package client.consume.extract;

import client.read.EventData;

public final class ExtractComponent extends Extractor<String> {
    private static final ExtractComponent instance = new ExtractComponent();

    public static Extractor<String> extractor() {
        return instance;
    }

    private ExtractComponent() {
        super();
    }

    @Override
    public final String extract(EventData eventData) {
        return eventData.valueForComponent();
    }
}