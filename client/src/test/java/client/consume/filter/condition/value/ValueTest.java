package client.consume.filter.condition.value;

import client.consume.extract.Extractor;
import client.read.EventData;

public abstract class ValueTest {
    protected static class NullExtractor<V> extends Extractor<V> {
        public static final NullExtractor<Object> extractor = new NullExtractor<Object>();
        public static final NullExtractor<Integer> integerExtractor = new NullExtractor<Integer>();
        public static final NullExtractor<String> stringExtractor = new NullExtractor<String>();

        public V extract(EventData eventData) {
            return null;
        }
    }
    
    protected static class IntegerExtractor extends Extractor<Integer> {
        public static final IntegerExtractor extractor = new IntegerExtractor(9);

        private final int value;

        public IntegerExtractor(int value) {
            this.value = value;
        }

        public Integer extract(EventData eventData) {
            return value;
        }
    }

    protected static class StringExtractor extends Extractor<String> {
        public static final StringExtractor extractor = new StringExtractor("ivo");
        
        private final String value;

        public StringExtractor(String value) {
            this.value = value;
        }

        public String extract(EventData eventData) {
            return value;
        }
    }
}