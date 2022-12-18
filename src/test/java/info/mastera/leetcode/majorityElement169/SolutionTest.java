package info.mastera.leetcode.majorityElement169;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals(3, new Solution().majorityElement(new int[]{3, 2, 3}));
        Assertions.assertEquals(2, new Solution().majorityElement(new int[]{2,2,1,1,1,2,2}));
        Assertions.assertEquals(2, new Solution().majorityElement(new int[]{2,2,2,2,1,1,1}));
        Assertions.assertEquals(2, new Solution().majorityElement(new int[]{2,2,2,2,3,4,1}));
    }
}