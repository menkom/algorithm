package info.mastera.leetcode.longestSubstringWithoutRepeatingCharacters3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals(Solution.lengthOfLongestSubstring("abcabcbb"), 3);
        Assertions.assertEquals(Solution.lengthOfLongestSubstring("bbbbb"), 1);
        Assertions.assertEquals(Solution.lengthOfLongestSubstring("pwwkew"), 3);
        Assertions.assertEquals(Solution.lengthOfLongestSubstring(""), 0);
        Assertions.assertEquals(Solution.lengthOfLongestSubstring(" "), 1);
        Assertions.assertEquals(Solution.lengthOfLongestSubstring("aab"), 2);
        Assertions.assertEquals(Solution.lengthOfLongestSubstring("tmmzuxt"), 5);
    }
}