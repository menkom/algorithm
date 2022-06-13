package info.mastera.leetcode.triangle120;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals(11, new Solution().minimumTotal(List.of(List.of(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3))));
        Assertions.assertEquals(6, new Solution().minimumTotal(List.of(List.of(1), Arrays.asList(5, 1), Arrays.asList(1, 2, 3), Arrays.asList(7, 9, 8, 1))));
        Assertions.assertEquals(-10, new Solution().minimumTotal(List.of(List.of(-10))));
    }
}