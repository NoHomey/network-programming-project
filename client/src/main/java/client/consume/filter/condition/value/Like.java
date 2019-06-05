package client.consume.filter.condition.value;

import java.util.regex.Pattern;

import client.consume.extract.Extractor;
import client.read.EventData;

public final class Like extends ValueCondition<String> {
    private static class IntegerExtractorWrapper extends Extractor<String> {
        private Extractor<Integer> extractor;

        public IntegerExtractorWrapper(Extractor<Integer> extractor) {
            super();
            this.extractor = extractor;
        }

        @Override
        public final String extract(EventData eventData) {
            final Integer value = extractor.extract(eventData);
            if(value != null) {
                return value.toString();
            } else {
                return null;
            }
        }
    }

    private final Pattern pattern;

    public static Like fromIntegerExtractor(Extractor<Integer> extractor, String regex) throws IllegalArgumentException {
        return new Like(new IntegerExtractorWrapper(extractor), regex);
    }

    public Like(Extractor<String> extractor, String regex) throws IllegalArgumentException {
        super(extractor);
        if(regex == null) {
            throw new IllegalArgumentException("regex should not be null");
        }
        pattern = Pattern.compile(regex);
    }

    @Override
    protected final boolean check(String value) {
        final boolean b = value == null ? false : pattern.matcher(value).matches();
        return b;
    }
}