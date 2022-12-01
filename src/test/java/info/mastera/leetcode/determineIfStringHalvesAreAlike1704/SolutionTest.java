package info.mastera.leetcode.determineIfStringHalvesAreAlike1704;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    public void test() {
        assertTrue(new Solution().halvesAreAlike("book"));
        assertFalse(new Solution().halvesAreAlike("textbook"));
    }
}