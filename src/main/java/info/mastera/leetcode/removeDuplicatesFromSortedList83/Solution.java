package info.mastera.leetcode.removeDuplicatesFromSortedList83;

import info.mastera.leetcode.ListNode;

/**
 * 83. Remove Duplicates from Sorted List
 * Easy
 * Topics
 * Companies
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,1,2]
 * Output: [1,2]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 */
public class Solution {

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.val == head.val) {
            head.next = head.next.next;
            return deleteDuplicates(head);
        }
        head.next = deleteDuplicates(head.next);
        return head;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
