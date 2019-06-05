package client.consume.extract;

import client.read.EventData;

public final class ExtractActivity extends Extractor<String> {
    private static final ExtractActivity instance = new ExtractActivity();

    public static Extractor<String> extractor() {
        return instance;
    }

    private ExtractActivity() {
        super();
    }

    @Override
    public final String extract(EventData eventData) {
        return eventData.valueForActivity();
    }
}