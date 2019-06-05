package client.consume.filter.condition.value.relation;

import org.junit.Test;
import static org.junit.Assert.*;

import client.consume.filter.condition.value.ValueTest;

public class NotEqualToValueTest extends ValueTest {
    @Test
    public void testWhenValueIsNullThrows() {
        try {
            new NotEqualToValue<Object>(ValueTest.NullExtractor.extractor, null);
            fail();
        } catch(IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testIsTrueWhenValueIsNullIsFalse() {
        final NotEqualToValue<Integer> c1 = new NotEqualToValue<Integer>(ValueTest.NullExtractor.integerExtractor, 9);
        final NotEqualToValue<String> c2 = new NotEqualToValue<String>(ValueTest.NullExtractor.stringExtractor, "abc");
        assertFalse(c1.isTrue(null));
        assertFalse(c2.isTrue(null));
    }

    @Test
    public void testIsTrueWhenNotEqualsIsTrue() {
        final NotEqualToValue<Integer> c1 = new NotEqualToValue<Integer>(new ValueTest.IntegerExtractor(8), 9);
        assertTrue(c1.isTrue(null));
        final NotEqualToValue<Integer> c2 = new NotEqualToValue<Integer>(new ValueTest.IntegerExtractor(-22), 9);
        assertTrue(c2.isTrue(null));

        final NotEqualToValue<String> c3 = new NotEqualToValue<String>(new ValueTest.StringExtractor("abcd"), "abc");
        assertTrue(c3.isTrue(null));
        final NotEqualToValue<String> c4 = new NotEqualToValue<String>(new ValueTest.StringExtractor("ab"), "abc");
        assertTrue(c4.isTrue(null));
    }

    @Test
    public void testIsTrueWhenEqualsIsFalse() {
        final NotEqualToValue<Integer> c1 = new NotEqualToValue<Integer>(new ValueTest.IntegerExtractor(9), 9);
        assertFalse(c1.isTrue(null));

        final NotEqualToValue<String> c2 = new NotEqualToValue<String>(new ValueTest.StringExtractor("abc"), "abc");
        assertFalse(c2.isTrue(null));
    }
}