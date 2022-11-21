package info.mastera.leetcode.searchInsertPosition35;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals(0, new Solution().searchInsert(new int[]{1}, 0));
        Assertions.assertEquals(0, new Solution().searchInsert(new int[]{1}, 1));
        Assertions.assertEquals(1, new Solution().searchInsert(new int[]{1}, 2));
        Assertions.assertEquals(1, new Solution().searchInsert(new int[]{1, 2}, 2));
        Assertions.assertEquals(1, new Solution().searchInsert(new int[]{1, 3}, 2));
        Assertions.assertEquals(2, new Solution().searchInsert(new int[]{1, 3}, 4));
        Assertions.assertEquals(2, new Solution().searchInsert(new int[]{1,3,5}, 4));
        Assertions.assertEquals(0, new Solution().searchInsert(new int[]{1, 3, 5, 6}, 0));
        Assertions.assertEquals(2, new Solution().searchInsert(new int[]{1, 3, 5, 6}, 5));
        Assertions.assertEquals(1, new Solution().searchInsert(new int[]{1, 3, 5, 6}, 2));
        Assertions.assertEquals(2, new Solution().searchInsert(new int[]{1, 3, 5, 6}, 4));
        Assertions.assertEquals(4, new Solution().searchInsert(new int[]{1, 3, 5, 6}, 7));
        Assertions.assertEquals(6, new Solution().searchInsert(new int[]{1,2,4,6,8,9,10}, 10));
    }
}