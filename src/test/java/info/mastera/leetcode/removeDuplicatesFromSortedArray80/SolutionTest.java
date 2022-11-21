package info.mastera.leetcode.removeDuplicatesFromSortedArray80;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals(1, new Solution().removeDuplicates(new int[]{1}));
        Assertions.assertEquals(2, new Solution().removeDuplicates(new int[]{1, 1}));
        Assertions.assertEquals(2, new Solution().removeDuplicates(new int[]{1, 1, 1}));
        Assertions.assertEquals(2, new Solution().removeDuplicates(new int[]{1, 1, 1, 1}));
        Assertions.assertEquals(2, new Solution().removeDuplicates(new int[]{1, 1, 1, 1, 1}));
        Assertions.assertEquals(2, new Solution().removeDuplicates(new int[]{1, 2}));
        Assertions.assertEquals(3, new Solution().removeDuplicates(new int[]{1, 1, 2}));
        Assertions.assertEquals(4, new Solution().removeDuplicates(new int[]{1, 1, 2, 2, 2, 2, 2}));
        Assertions.assertEquals(3, new Solution().removeDuplicates(new int[]{1, 1, 1, 2}));
        Assertions.assertEquals(4, new Solution().removeDuplicates(new int[]{1, 1, 2, 2}));
        Assertions.assertEquals(4, new Solution().removeDuplicates(new int[]{1, 1, 2, 2, 2}));
        Assertions.assertEquals(5, new Solution().removeDuplicates(new int[]{1, 1, 2, 2, 3}));
        Assertions.assertEquals(5, new Solution().removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        Assertions.assertEquals(7, new Solution().removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }
}