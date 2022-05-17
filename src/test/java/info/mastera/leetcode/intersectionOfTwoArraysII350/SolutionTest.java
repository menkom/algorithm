package info.mastera.leetcode.intersectionOfTwoArraysII350;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertArrayEquals(Solution.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}), new int[]{2, 2});
        Assertions.assertArrayEquals(Solution.intersect(new int[]{4, 9, 5}, new int[]{9,4,9,8,4}), new int[]{9,4});
    }
}