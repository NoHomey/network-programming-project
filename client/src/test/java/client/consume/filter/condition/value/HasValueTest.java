package client.consume.filter.condition.value;

import org.junit.Test;
import static org.junit.Assert.*;

public class HasValueTest extends ValueTest {
    @Test
    public void testIsTrueWhenValueIsNullIsFalse() {
        final HasValue<Object> c1 = new HasValue<Object>(ValueTest.NullExtractor.extractor);
        final HasValue<Integer> c2 = new HasValue<Integer>(ValueTest.NullExtractor.integerExtractor);
        final HasValue<String> c3 = new HasValue<String>(ValueTest.NullExtractor.stringExtractor);
        assertFalse(c1.isTrue(null));
        assertFalse(c2.isTrue(null));
        assertFalse(c3.isTrue(null));
    }

    @Test
    public void testIsTrueWhenValueIsNotNullIsTrue() {
        final HasValue<Integer> c1 = new HasValue<Integer>(ValueTest.IntegerExtractor.extractor);
        final HasValue<String> c2 = new HasValue<String>(ValueTest.StringExtractor.extractor);
        assertTrue(c1.isTrue(null));
        assertTrue(c2.isTrue(null));
    }
}