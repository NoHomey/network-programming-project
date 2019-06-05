package client.consume.filter.condition.value.relation;

import org.junit.Test;
import static org.junit.Assert.*;

import client.consume.filter.condition.value.ValueTest;

public class LessThanValueTest extends ValueTest {
    @Test
    public void testWhenValueIsNullThrows() {
        try {
            new LessThanValue<Integer>(ValueTest.NullExtractor.integerExtractor, null);
            fail();
        } catch(IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testIsTrueWhenNullIsFalse() {
        final LessThanValue<Integer> c1 = new LessThanValue<Integer>(ValueTest.NullExtractor.integerExtractor, 9);
        final LessThanValue<String> c2 = new LessThanValue<String>(ValueTest.NullExtractor.stringExtractor, "abc");
        assertFalse(c1.isTrue(null));
        assertFalse(c2.isTrue(null));
    }

    @Test
    public void testIsTrueWhenLessIsTrue() {
        final LessThanValue<Integer> c1 = new LessThanValue<Integer>(new ValueTest.IntegerExtractor(9), 10);
        assertTrue(c1.isTrue(null));
        final LessThanValue<Integer> c2 = new LessThanValue<Integer>(new ValueTest.IntegerExtractor(-100), 10);
        assertTrue(c2.isTrue(null));

        final LessThanValue<String> c3 = new LessThanValue<String>(new ValueTest.StringExtractor("abc"), "abd");
        assertTrue(c3.isTrue(null));
        final LessThanValue<String> c4 = new LessThanValue<String>(new ValueTest.StringExtractor("ab"), "abd");
        assertTrue(c4.isTrue(null));
    }

    @Test
    public void testIsTrueWhenGreaterOrEqualIsFalse() {
        final LessThanValue<Integer> c1 = new LessThanValue<Integer>(new ValueTest.IntegerExtractor(11), 10);
        assertFalse(c1.isTrue(null));
        final LessThanValue<Integer> c2 = new LessThanValue<Integer>(new ValueTest.IntegerExtractor(10), 10);
        assertFalse(c2.isTrue(null));

        final LessThanValue<String> c3 = new LessThanValue<String>(new ValueTest.StringExtractor("abd"), "abd");
        assertFalse(c3.isTrue(null));
        final LessThanValue<String> c4 = new LessThanValue<String>(new ValueTest.StringExtractor("ad"), "abd");
        assertFalse(c4.isTrue(null));
    }
}