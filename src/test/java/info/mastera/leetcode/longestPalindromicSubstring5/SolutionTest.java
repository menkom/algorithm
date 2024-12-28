package info.mastera.leetcode.longestPalindromicSubstring5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void longestPalindromeTest() {

        Solution solution = new Solution();

        assertEquals("a", solution.longestPalindrome("a"));
//        assertEquals("bab", solution.longestPalindrome("babad"));
        assertEquals("aba", solution.longestPalindrome("babad"));
        assertEquals("bb", solution.longestPalindrome("cbbd"));
    }
}