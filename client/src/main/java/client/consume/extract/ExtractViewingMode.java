package client.consume.extract;

import client.read.EventData;

public final class ExtractViewingMode extends Extractor<String> {
    private static final ExtractViewingMode instance = new ExtractViewingMode();

    public static Extractor<String> extractor() {
        return instance;
    }

    private ExtractViewingMode() {
        super();
    }

    @Override
    public final String extract(EventData eventData) {
        return eventData.valueForViewingMode();
    }
}