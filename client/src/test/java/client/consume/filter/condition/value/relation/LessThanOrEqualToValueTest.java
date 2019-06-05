package client.consume.filter.condition.value.relation;

import org.junit.Test;
import static org.junit.Assert.*;

import client.consume.filter.condition.value.ValueTest;

public class LessThanOrEqualToValueTest extends ValueTest {
    @Test
    public void testWhenValueIsNullThrows() {
        try {
            new LessThanOrEqualToValue<Integer>(ValueTest.NullExtractor.integerExtractor, null);
            fail();
        } catch(IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testIsTrueWhenNullIsFalse() {
        final LessThanOrEqualToValue<Integer> c1 = new LessThanOrEqualToValue<Integer>(ValueTest.NullExtractor.integerExtractor, 9);
        final LessThanOrEqualToValue<String> c2 = new LessThanOrEqualToValue<String>(ValueTest.NullExtractor.stringExtractor, "abc");
        assertFalse(c1.isTrue(null));
        assertFalse(c2.isTrue(null));
    }

    @Test
    public void testIsTrueWhenLessOrEqualIsTrue() {
        final LessThanOrEqualToValue<Integer> c1 = new LessThanOrEqualToValue<Integer>(new ValueTest.IntegerExtractor(10), 10);
        assertTrue(c1.isTrue(null));
        final LessThanOrEqualToValue<Integer> c2 = new LessThanOrEqualToValue<Integer>(new ValueTest.IntegerExtractor(-100), 10);
        assertTrue(c2.isTrue(null));

        final LessThanOrEqualToValue<String> c3 = new LessThanOrEqualToValue<String>(new ValueTest.StringExtractor("abd"), "abd");
        assertTrue(c3.isTrue(null));
        final LessThanOrEqualToValue<String> c4 = new LessThanOrEqualToValue<String>(new ValueTest.StringExtractor("ab"), "abd");
        assertTrue(c4.isTrue(null));
    }

    @Test
    public void testIsTrueWhenGreaterIsFalse() {
        final LessThanOrEqualToValue<Integer> c1 = new LessThanOrEqualToValue<Integer>(new ValueTest.IntegerExtractor(11), 10);
        assertFalse(c1.isTrue(null));
        final LessThanOrEqualToValue<Integer> c2 = new LessThanOrEqualToValue<Integer>(new ValueTest.IntegerExtractor(100), 10);
        assertFalse(c2.isTrue(null));

        final LessThanOrEqualToValue<String> c3 = new LessThanOrEqualToValue<String>(new ValueTest.StringExtractor("abda"), "abd");
        assertFalse(c3.isTrue(null));
        final LessThanOrEqualToValue<String> c4 = new LessThanOrEqualToValue<String>(new ValueTest.StringExtractor("ad"), "abd");
        assertFalse(c4.isTrue(null));
    }
}