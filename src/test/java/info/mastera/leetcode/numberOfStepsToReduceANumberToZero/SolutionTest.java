package info.mastera.leetcode.numberOfStepsToReduceANumberToZero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals(new Solution().numberOfSteps(0), 0);
        Assertions.assertEquals(new Solution().numberOfSteps(1), 1);
        Assertions.assertEquals(new Solution().numberOfSteps(14), 6);
        Assertions.assertEquals(new Solution().numberOfSteps(13), 6);
        Assertions.assertEquals(new Solution().numberOfSteps(12), 5);
        Assertions.assertEquals(new Solution().numberOfSteps(11), 6);
        Assertions.assertEquals(new Solution().numberOfSteps(8), 4);
        Assertions.assertEquals(new Solution().numberOfSteps(123), 12);
    }
}