package info.mastera.leetcode.containsDuplicate217;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals(true, new Solution().containsDuplicate(new int[]{1, 2, 3, 1}));
        Assertions.assertEquals(false, new Solution().containsDuplicate(new int[]{1, 2, 3, 4}));
        Assertions.assertEquals(true, new Solution().containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }
}