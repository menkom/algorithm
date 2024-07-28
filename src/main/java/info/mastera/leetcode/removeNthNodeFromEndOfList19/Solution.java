package info.mastera.leetcode.removeNthNodeFromEndOfList19;

import info.mastera.leetcode.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * Medium
 * <p>
 * Hint
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 * <p>
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 * <p>
 * Input: head = [1,2], n = 1
 * Output: [1]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class Solution {

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        if (length == n) {
            return head == null ? head : head.next;
        }
        current = head;
        int positionBeforeDelete = length - n;
        while (current != null) {
            positionBeforeDelete--;
            if (positionBeforeDelete == 0) {
                current.next = current.next == null
                        ? null
                        : current.next.next;
                return head;
            }
            current = current.next;
        }
        return head;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int gap = 0;
        ListNode current = head;
        ListNode delete = head;
        while (current != null) {
            if (gap <= n) {
                gap++;
            } else {
                delete = delete.next;
            }
            current = current.next;
        }
        if (gap == n) {
            return head == null ? head : head.next;
        }
        if (delete != null && delete.next != null) {
            delete.next = delete.next.next;
        }
        return head;
    }
}
