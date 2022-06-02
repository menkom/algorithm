package info.mastera.leetcode.palindromeNumber9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void test() {
        Assertions.assertEquals(true, new Solution().isPalindrome(121));
        Assertions.assertEquals(false, new Solution().isPalindrome(-121));
        Assertions.assertEquals(false, new Solution().isPalindrome(10));
    }
}