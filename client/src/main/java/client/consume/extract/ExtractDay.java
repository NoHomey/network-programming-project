package client.consume.extract;

import client.read.EventData;

public final class ExtractDay extends Extractor<Integer> {
    private static final ExtractDay instance = new ExtractDay();

    public static Extractor<Integer> extractor() {
        return instance;
    }

    private ExtractDay() {
        super();
    }

    @Override
    public final Integer extract(EventData eventData) {
        return eventData.valueForDay();
    }
}