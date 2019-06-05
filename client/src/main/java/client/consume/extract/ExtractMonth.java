package client.consume.extract;

import client.read.EventData;

public final class ExtractMonth extends Extractor<Integer> {
    private static final ExtractMonth instance = new ExtractMonth();

    public static Extractor<Integer> extractor() {
        return instance;
    }

    private ExtractMonth() {
        super();
    }

    @Override
    public final Integer extract(EventData eventData) {
        return eventData.valueForMonth();
    }
}