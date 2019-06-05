package client.consume.extract;

import client.read.EventData;

public final class ExtractPostID extends Extractor<Integer> {
    private static final ExtractPostID instance = new ExtractPostID();

    public static Extractor<Integer> extractor() {
        return instance;
    }

    private ExtractPostID() {
        super();
    }

    @Override
    public final Integer extract(EventData eventData) {
        return eventData.valueForPostID();
    }
}