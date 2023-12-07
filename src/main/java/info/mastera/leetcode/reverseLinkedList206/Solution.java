package info.mastera.leetcode.reverseLinkedList206;

import info.mastera.leetcode.ListNode;

/**
 * 206. Reverse Linked List
 * Easy
 * 20.2K
 * 373
 * Companies
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 * <p>
 * Input: head = []
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 * <p>
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class Solution {

    public ListNode reverseList1(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;
        while (null != current) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static ListNode reverseList(ListNode root) {
        if (null == root) {
            return null;
        }
        ListNode previous = null;
        ListNode current = root;
        ListNode next = current.next;
        current.next = previous;
        previous = current;

        while (null != next) {
            current = next;
            next = current.next;
            current.next = previous;
            previous = current;
        }
        return current;
    }
}
