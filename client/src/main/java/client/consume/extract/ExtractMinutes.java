package client.consume.extract;

import client.read.EventData;

public final class ExtractMinutes extends Extractor<Integer> {
    private static final ExtractMinutes instance = new ExtractMinutes();

    public static Extractor<Integer> extractor() {
        return instance;
    }

    private ExtractMinutes() {
        super();
    }

    @Override
    public final Integer extract(EventData eventData) {
        return eventData.valueForMinutes();
    }
}