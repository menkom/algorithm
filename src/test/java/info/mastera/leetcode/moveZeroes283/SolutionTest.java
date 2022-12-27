package info.mastera.leetcode.moveZeroes283;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        int[] nums = new int[]{};
        new Solution().moveZeroes(nums);
        Assertions.assertArrayEquals(new int[]{}, nums);

        nums = new int[]{0};
        new Solution().moveZeroes(nums);
        Assertions.assertArrayEquals(new int[]{0}, nums);

        nums = new int[]{0,1,0,3,12};
        new Solution().moveZeroes(nums);

        Assertions.assertArrayEquals(new int[]{1,3,12,0,0}, nums);
    }
}