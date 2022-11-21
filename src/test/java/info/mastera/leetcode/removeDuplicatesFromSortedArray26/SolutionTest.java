package info.mastera.leetcode.removeDuplicatesFromSortedArray26;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test(){
        Assertions.assertEquals(1, new Solution().removeDuplicates(new int[]{1,1,1}));
        Assertions.assertEquals(2, new Solution().removeDuplicates(new int[]{1,1,2}));
        Assertions.assertEquals(5, new Solution().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}