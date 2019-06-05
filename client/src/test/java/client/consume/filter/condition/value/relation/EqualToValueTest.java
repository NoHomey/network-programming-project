package client.consume.filter.condition.value.relation;

import org.junit.Test;
import static org.junit.Assert.*;

import client.consume.filter.condition.value.ValueTest;

public class EqualToValueTest extends ValueTest {
    @Test
    public void testWhenValueIsNullThrows() {
        try {
            new EqualToValue<Object>(ValueTest.NullExtractor.extractor, null);
            fail();
        } catch(IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testIsTrueWhenNullIsFalse() {
        final EqualToValue<Integer> c1 = new EqualToValue<Integer>(ValueTest.NullExtractor.integerExtractor, 9);
        final EqualToValue<String> c2 = new EqualToValue<String>(ValueTest.NullExtractor.stringExtractor, "abc");
        assertFalse(c1.isTrue(null));
        assertFalse(c2.isTrue(null));
    }

    @Test
    public void testIsTrueWhenEqualIsTrue() {
        final EqualToValue<Integer> c1 = new EqualToValue<Integer>(new ValueTest.IntegerExtractor(9), 9);
        assertTrue(c1.isTrue(null));

        final EqualToValue<String> c2 = new EqualToValue<String>(new ValueTest.StringExtractor("abc"), "abc");
        assertTrue(c2.isTrue(null));
    }

    @Test
    public void testIsTrueWhenNotEqualIsFalse() {
        final EqualToValue<Integer> c1 = new EqualToValue<Integer>(new ValueTest.IntegerExtractor(7), 9);
        assertFalse(c1.isTrue(null));

        final EqualToValue<String> c2 = new EqualToValue<String>(new ValueTest.StringExtractor("ivo"), "abc");
        assertFalse(c2.isTrue(null));
    }
}