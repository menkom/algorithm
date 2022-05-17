package info.mastera.leetcode.addTwoNumbers2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    public void test() {
        Assertions.assertEquals(Solution.addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4)))), new ListNode(7, new ListNode(0, new ListNode(8))));
        Assertions.assertEquals(Solution.addTwoNumbers(new ListNode(2, 4, 3), new ListNode(5, 6, 4)), new ListNode(7, 0, 8));
        Assertions.assertEquals(Solution.addTwoNumbers(new ListNode(0), new ListNode(0)), new ListNode(0));
        Assertions.assertEquals(Solution.addTwoNumbers(new ListNode(9, 9, 9, 9, 9, 9, 9), new ListNode(9, 9, 9, 9)), new ListNode(8, 9, 9, 9, 0, 0, 0, 1));
    }
}