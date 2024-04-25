package info.mastera.leetcode.removeDuplicatesFromSortedList83;

import info.mastera.leetcode.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test() {
        final Solution solution = new Solution();
        Assertions.assertEquals(new ListNode(1), solution.deleteDuplicates(new ListNode(1)));
        Assertions.assertEquals(new ListNode(1), solution.deleteDuplicates(new ListNode(1, 1)));
        Assertions.assertEquals(new ListNode(1), solution.deleteDuplicates(new ListNode(1, 1, 1)));
        Assertions.assertEquals(new ListNode(1), solution.deleteDuplicates(new ListNode(1, 1, 1, 1)));
        Assertions.assertEquals(new ListNode(1, 2), solution.deleteDuplicates(new ListNode(1, 2)));
        Assertions.assertEquals(new ListNode(1, 2), solution.deleteDuplicates(new ListNode(1, 1, 2)));
        Assertions.assertEquals(new ListNode(1, 2, 3), solution.deleteDuplicates(new ListNode(1, 1, 2, 3, 3)));
    }
}