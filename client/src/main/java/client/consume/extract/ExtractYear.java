package client.consume.extract;

import client.read.EventData;

public final class ExtractYear extends Extractor<Integer> {
    private static final ExtractYear instance = new ExtractYear();

    public static Extractor<Integer> extractor() {
        return instance;
    }

    private ExtractYear() {
        super();
    }

    @Override
    public final Integer extract(EventData eventData) {
        return eventData.valueForYear();
    }
}