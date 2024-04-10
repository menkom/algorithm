package info.mastera.leetcode.addBinary67;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals("0", new Solution().addBinary("0", "0"));
        Assertions.assertEquals("1", new Solution().addBinary("0", "1"));
        Assertions.assertEquals("1", new Solution().addBinary("1", "0"));
        Assertions.assertEquals("10", new Solution().addBinary("1", "1"));

        Assertions.assertEquals("10", new Solution().addBinary("10", "0"));
        Assertions.assertEquals("10", new Solution().addBinary("0", "10"));
        Assertions.assertEquals("11", new Solution().addBinary("1", "10"));
        Assertions.assertEquals("100", new Solution().addBinary("1", "11"));
        Assertions.assertEquals("11", new Solution().addBinary("10", "1"));
        Assertions.assertEquals("100", new Solution().addBinary("11", "1"));
        Assertions.assertEquals("10101", new Solution().addBinary("1010", "1011"));
        Assertions.assertEquals("10000", new Solution().addBinary("1111", "1"));
    }
}