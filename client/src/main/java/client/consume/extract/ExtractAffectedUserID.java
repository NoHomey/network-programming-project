package client.consume.extract;

import client.read.EventData;

public final class ExtractAffectedUserID extends Extractor<Integer> {
    private static final ExtractAffectedUserID instance = new ExtractAffectedUserID();

    public static Extractor<Integer> extractor() {
        return instance;
    }

    private ExtractAffectedUserID() {
        super();
    }

    @Override
    public final Integer extract(EventData eventData) {
        return eventData.valueForAffectedUserID();
    }
}