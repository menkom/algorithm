package info.mastera.leetcode.countOperationsToObtainZero2169;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test(){
        Assertions.assertEquals(new Solution().countOperations(2,3),3);
        Assertions.assertEquals(new Solution().countOperations(10,10),1);
    }
}