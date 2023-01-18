package info.mastera.leetcode.validAnagram242;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertTrue(new Solution().isAnagram("anagram", "nagaram"));
        Assertions.assertFalse(new Solution().isAnagram("rat", "car"));
        Assertions.assertFalse(new Solution().isAnagram("aat", "tta"));
    }
}