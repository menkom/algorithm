package info.mastera.leetcode.removeElement27;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals(2, new Solution().removeElement(new int[]{3,2,2,3},3));
        Assertions.assertEquals(5, new Solution().removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }
}