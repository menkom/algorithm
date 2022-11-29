package info.mastera.leetcode.mergeSortedArray88;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void test() {
        var nums1 = new int[]{1, 2, 3, 0, 0, 0};
        new Solution().merge(nums1, 3, new int[]{2, 5, 6}, 3);
        Assertions.assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);

        nums1 = new int[]{1};
        new Solution().merge(nums1, 1, new int[]{}, 0);
        Assertions.assertArrayEquals(new int[]{1}, nums1);

        nums1 = new int[]{0};
        new Solution().merge(nums1, 0, new int[]{1}, 1);
        Assertions.assertArrayEquals(new int[]{1}, nums1);

        nums1 = new int[]{0, 0, 0};
        new Solution().merge(nums1, 0, new int[]{1, 1, 1}, 3);
        Assertions.assertArrayEquals(new int[]{1, 1, 1}, nums1);
    }
}