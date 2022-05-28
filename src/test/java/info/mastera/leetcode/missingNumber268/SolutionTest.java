package info.mastera.leetcode.missingNumber268;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals(new Solution().missingNumber(new int[]{3, 0, 1}), 2);
        Assertions.assertEquals(new Solution().missingNumber(new int[]{0, 1}), 2);
        Assertions.assertEquals(new Solution().missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}), 8);
    }
}