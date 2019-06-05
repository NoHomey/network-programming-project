package client.consume.extract;

import client.read.EventData;

public final class ExtractItemID extends Extractor<Integer> {
    private static final ExtractItemID instance = new ExtractItemID();

    public static Extractor<Integer> extractor() {
        return instance;
    }

    private ExtractItemID() {
        super();
    }

    @Override
    public final Integer extract(EventData eventData) {
        return eventData.valueForItemID();
    }
}