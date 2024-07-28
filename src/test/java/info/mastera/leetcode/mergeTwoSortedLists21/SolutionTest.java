package info.mastera.leetcode.mergeTwoSortedLists21;

import info.mastera.leetcode.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test() {
        var resultToTest = new Solution().mergeTwoLists(new ListNode(1, 2, 4), new ListNode(1, 3, 4));
        Assertions.assertEquals(new ListNode(1, 1, 2, 3, 4, 4), resultToTest);

        resultToTest = new Solution().mergeTwoLists(new ListNode(1), new ListNode(1));
        Assertions.assertEquals(new ListNode(1, 1), resultToTest);

        resultToTest = new Solution().mergeTwoLists(null, null);
        Assertions.assertNull(resultToTest);

        resultToTest = new Solution().mergeTwoLists(null, new ListNode(0));
        Assertions.assertEquals(new ListNode(0), resultToTest);

        resultToTest = new Solution().mergeTwoLists(new ListNode(0), null);
        Assertions.assertEquals(new ListNode(0), resultToTest);
    }
}