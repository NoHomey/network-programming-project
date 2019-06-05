package client.consume.filter.condition.value.relation;

import org.junit.Test;
import static org.junit.Assert.*;

import client.consume.filter.condition.value.ValueTest;

public class GreaterThanOrEqualToValueTest extends ValueTest {
    @Test
    public void testWhenValueIsNullThrows() {
        try {
            new GreaterThanOrEqualToValue<Integer>(ValueTest.NullExtractor.integerExtractor, null);
            fail();
        } catch(IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testIsTrueWhenNullIsFalse() {
        final GreaterThanOrEqualToValue<Integer> c1 = new GreaterThanOrEqualToValue<Integer>(ValueTest.NullExtractor.integerExtractor, 9);
        final GreaterThanOrEqualToValue<String> c2 = new GreaterThanOrEqualToValue<String>(ValueTest.NullExtractor.stringExtractor, "abc");
        assertFalse(c1.isTrue(null));
        assertFalse(c2.isTrue(null));
    }

    @Test
    public void testIsTrueWhenGreaterOrEqualIsTrue() {
        final GreaterThanOrEqualToValue<Integer> c1 = new GreaterThanOrEqualToValue<Integer>(new ValueTest.IntegerExtractor(11), 10);
        assertTrue(c1.isTrue(null));
        final GreaterThanOrEqualToValue<Integer> c2 = new GreaterThanOrEqualToValue<Integer>(new ValueTest.IntegerExtractor(10), 10);
        assertTrue(c2.isTrue(null));

        final GreaterThanOrEqualToValue<String> c3 = new GreaterThanOrEqualToValue<String>(new ValueTest.StringExtractor("abf"), "abd");
        assertTrue(c3.isTrue(null));
        final GreaterThanOrEqualToValue<String> c4 = new GreaterThanOrEqualToValue<String>(new ValueTest.StringExtractor("abd"), "abd");
        assertTrue(c4.isTrue(null));
    }

    @Test
    public void testIsTrueWhenLessIsFalse() {
        final GreaterThanOrEqualToValue<Integer> c1 = new GreaterThanOrEqualToValue<Integer>(new ValueTest.IntegerExtractor(9), 10);
        assertFalse(c1.isTrue(null));
        final GreaterThanOrEqualToValue<Integer> c2 = new GreaterThanOrEqualToValue<Integer>(new ValueTest.IntegerExtractor(-10), 10);
        assertFalse(c2.isTrue(null));

        final GreaterThanOrEqualToValue<String> c3 = new GreaterThanOrEqualToValue<String>(new ValueTest.StringExtractor("ab"), "abd");
        assertFalse(c3.isTrue(null));
        final GreaterThanOrEqualToValue<String> c4 = new GreaterThanOrEqualToValue<String>(new ValueTest.StringExtractor("aa"), "abd");
        assertFalse(c4.isTrue(null));
    }
}