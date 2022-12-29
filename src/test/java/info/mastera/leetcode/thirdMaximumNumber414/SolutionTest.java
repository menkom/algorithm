package info.mastera.leetcode.thirdMaximumNumber414;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test() {
        Assertions.assertEquals(1, new Solution().thirdMax(new int[]{3, 2, 1}));
        Assertions.assertEquals(2, new Solution().thirdMax(new int[]{1, 2}));
        Assertions.assertEquals(1, new Solution().thirdMax(new int[]{2, 2, 3, 1}));
    }
}