package info.mastera.leetcode.medianOfTwoSortedArrays4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals(4.5, new Solution().findMedianSortedArrays(new int[]{1, 3, 6}, new int[]{2, 8, 12}));
        Assertions.assertEquals(5.5, new Solution().findMedianSortedArrays(new int[]{1, 3, 4, 6, 9}, new int[]{2, 5, 7, 8, 10}));
        Assertions.assertEquals(2, new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        Assertions.assertEquals(2.5, new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}