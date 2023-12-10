package info.mastera.leetcode.reverseLinkedList92;

import info.mastera.leetcode.ListNode;

/**
 * 92. Reverse Linked List II
 * Medium
 * 11.1K
 * 529
 * Companies
 * Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * Example 2:
 * <p>
 * Input: head = [5], left = 1, right = 1
 * Output: [5]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is n.
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * <p>
 * Follow up: Could you do it in one pass?
 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (null == head || null == head.next) {
            return head;
        }

        int index = 1;
        ListNode previous = null;
        ListNode current = head;
        while (null != current) {
            if (left <= index) {
                if (null == previous) {
                    head = reverseList(current, index, right);
                } else {
                    previous.next = reverseList(current, index, right);
                }
                return head;
            } else {
                previous = current;
                current = current.next;
                index++;
            }
        }
        return head;
    }

    public ListNode reverseList(ListNode node, int index, int right) {
        ListNode previous = null;
        ListNode current = node;
        ListNode next = node.next;
        while (index <= right) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            index++;
        }
        node.next = next;
        return previous;
    }
}
