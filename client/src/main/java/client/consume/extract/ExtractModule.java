package client.consume.extract;

import client.read.EventData;

public final class ExtractModule extends Extractor<String> {
    private static final ExtractModule instance = new ExtractModule();

    public static Extractor<String> extractor() {
        return instance;
    }

    private ExtractModule() {
        super();
    }

    @Override
    public final String extract(EventData eventData) {
        return eventData.valueForModule();
    }
}