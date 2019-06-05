package client.consume.extract;

import client.read.EventData;

public final class ExtractRoleID extends Extractor<Integer> {
    private static final ExtractRoleID instance = new ExtractRoleID();

    public static Extractor<Integer> extractor() {
        return instance;
    }

    private ExtractRoleID() {
        super();
    }

    @Override
    public final Integer extract(EventData eventData) {
        return eventData.valueForRoleID();
    }
}