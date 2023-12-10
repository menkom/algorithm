package info.mastera.leetcode.reverseLinkedList92;

import info.mastera.leetcode.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test() {
        ListNode root = new ListNode(5);
        ListNode resultToTest = new Solution().reverseBetween(root, 1, 1);
        System.out.println(root);
        System.out.println(resultToTest);
        Assertions.assertEquals(new ListNode(5), resultToTest);

        root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(root);
        resultToTest = new Solution().reverseBetween(root, 1, 2);
        System.out.println(resultToTest);
        Assertions.assertEquals(new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(5))))), resultToTest);

        root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(root);
        resultToTest = new Solution().reverseBetween(root, 2, 3);
        System.out.println(resultToTest);
        Assertions.assertEquals(new ListNode(1, new ListNode(3, new ListNode(2, new ListNode(4, new ListNode(5))))), resultToTest);

        root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(root);
        resultToTest = new Solution().reverseBetween(root, 2, 4);
        System.out.println(resultToTest);
        Assertions.assertEquals(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5))))), resultToTest);

        root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(root);
        resultToTest = new Solution().reverseBetween(root, 3, 4);
        System.out.println(resultToTest);
        Assertions.assertEquals(new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(3, new ListNode(5))))), resultToTest);

        root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(root);
        resultToTest = new Solution().reverseBetween(root, 4, 5);
        System.out.println(resultToTest);
        Assertions.assertEquals(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(5, new ListNode(4))))), resultToTest);

        root = new ListNode(3, new ListNode(5));
        System.out.println(root);
        resultToTest = new Solution().reverseBetween(root, 1, 1);
        System.out.println(resultToTest);
        Assertions.assertEquals(new ListNode(3, new ListNode(5)), resultToTest);

        root = new ListNode(3, new ListNode(5));
        System.out.println(root);
        resultToTest = new Solution().reverseBetween(root, 1, 2);
        System.out.println(resultToTest);
        Assertions.assertEquals(new ListNode(5, new ListNode(3)), resultToTest);
    }
}