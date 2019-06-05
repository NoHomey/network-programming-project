package client.consume.extract;

import client.read.EventData;

public final class ExtractSectionNumber extends Extractor<Integer> {
    private static final ExtractSectionNumber instance = new ExtractSectionNumber();

    public static Extractor<Integer> extractor() {
        return instance;
    }

    private ExtractSectionNumber() {
        super();
    }

    @Override
    public final Integer extract(EventData eventData) {
        return eventData.valueForSectionNumber();
    }
}