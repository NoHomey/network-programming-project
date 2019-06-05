package client.consume.extract;

import client.read.EventData;

public final class ExtractDiscussionID extends Extractor<Integer> {
    private static final ExtractDiscussionID instance = new ExtractDiscussionID();

    public static Extractor<Integer> extractor() {
        return instance;
    }

    private ExtractDiscussionID() {
        super();
    }

    @Override
    public final Integer extract(EventData eventData) {
        return eventData.valueForDiscussionID();
    }
}