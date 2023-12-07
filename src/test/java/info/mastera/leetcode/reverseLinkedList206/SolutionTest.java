package info.mastera.leetcode.reverseLinkedList206;


import info.mastera.leetcode.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test() {
        ListNode root = null;
        ListNode resultToTest = new Solution().reverseList(root);
        System.out.println(root);
        System.out.println(resultToTest);
        Assertions.assertNull(resultToTest);

        root = new ListNode(1);
        resultToTest = new Solution().reverseList(root);
        System.out.println(root);
        System.out.println(resultToTest);
        Assertions.assertEquals(new ListNode(1), resultToTest);

        root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(root);
        resultToTest = new Solution().reverseList(root);
        System.out.println(resultToTest);
        Assertions.assertEquals(new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))), resultToTest);
    }
}