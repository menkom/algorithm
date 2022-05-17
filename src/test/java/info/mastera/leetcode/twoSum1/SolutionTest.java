package info.mastera.leetcode.twoSum1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test1TwoSum() {
        Assertions.assertArrayEquals(Solution.twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{1, 0});
        Assertions.assertArrayEquals(Solution.twoSum(new int[]{3, 2, 4}, 6), new int[]{2, 1});
        Assertions.assertArrayEquals(Solution.twoSum(new int[]{3, 3}, 6), new int[]{1, 0});
    }
}