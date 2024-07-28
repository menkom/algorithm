package info.mastera.leetcode.removeNthNodeFromEndOfList19;

import info.mastera.leetcode.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test() {
        var resultToTest = new Solution().removeNthFromEnd(new ListNode(1, 2, 3, 4, 5), 5);
        Assertions.assertEquals(new ListNode(2, 3, 4, 5), resultToTest);

        resultToTest = new Solution().removeNthFromEnd(new ListNode(1, 2, 3, 4, 5), 4);
        Assertions.assertEquals(new ListNode(1, 3, 4, 5), resultToTest);

        resultToTest = new Solution().removeNthFromEnd(new ListNode(1, 2, 3, 4, 5), 3);
        Assertions.assertEquals(new ListNode(1, 2, 4, 5), resultToTest);

        resultToTest = new Solution().removeNthFromEnd(new ListNode(1, 2, 3, 4, 5), 2);
        Assertions.assertEquals(new ListNode(1, 2, 3, 5), resultToTest);

        resultToTest = new Solution().removeNthFromEnd(new ListNode(1, 2, 3, 4, 5), 1);
        Assertions.assertEquals(new ListNode(1, 2, 3, 4), resultToTest);

        resultToTest = new Solution().removeNthFromEnd(new ListNode(1), 1);
        Assertions.assertNull(resultToTest);

        resultToTest = new Solution().removeNthFromEnd(new ListNode(1, 2), 1);
        Assertions.assertEquals(new ListNode(1), resultToTest);

        resultToTest = new Solution().removeNthFromEnd(new ListNode(1, 2), 2);
        Assertions.assertEquals(new ListNode(2), resultToTest);
    }
}