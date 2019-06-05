package client.consume.filter.condition.value;

import org.junit.Test;
import static org.junit.Assert.*;

public class IsNullTest extends ValueTest {
    @Test
    public void testIsTrueWhenValueIsNullIsTrue() {
        final IsNull<Object> c1 = new IsNull<Object>(ValueTest.NullExtractor.extractor);
        final IsNull<Integer> c2 = new IsNull<Integer>(ValueTest.NullExtractor.integerExtractor);
        final IsNull<String> c3 = new IsNull<String>(ValueTest.NullExtractor.stringExtractor);
        assertTrue(c1.isTrue(null));
        assertTrue(c2.isTrue(null));
        assertTrue(c3.isTrue(null));
    }

    @Test
    public void testIsTrueWhenValueIsNotNullIsFalse() {
        final IsNull<Integer> c1 = new IsNull<Integer>(ValueTest.IntegerExtractor.extractor);
        final IsNull<String> c2 = new IsNull<String>(ValueTest.StringExtractor.extractor);
        assertFalse(c1.isTrue(null));
        assertFalse(c2.isTrue(null));
    }
}