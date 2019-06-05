package client.consume.extract;

import client.read.EventData;

public final class ExtractHour extends Extractor<Integer> {
    private static final ExtractHour instance = new ExtractHour();

    public static Extractor<Integer> extractor() {
        return instance;
    }

    private ExtractHour() {
        super();
    }

    @Override
    public final Integer extract(EventData eventData) {
        return eventData.valueForHour();
    }
}