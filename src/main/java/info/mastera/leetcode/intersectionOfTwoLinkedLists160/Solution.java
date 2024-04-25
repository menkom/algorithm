package info.mastera.leetcode.intersectionOfTwoLinkedLists160;

import info.mastera.leetcode.ListNode;

import java.util.*;

/**
 * 160. Intersection of Two Linked Lists
 * Easy
 * <p>
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 * <p>
 * For example, the following two linked lists begin to intersect at node c1:
 * <p>
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 * <p>
 * Note that the linked lists must retain their original structure after the function returns.
 * <p>
 * Custom Judge:
 * <p>
 * The inputs to the judge are given as follows (your program is not given these inputs):
 * <p>
 * intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
 * <p>
 * The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 * <p>
 * Example 2:
 * <p>
 * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Intersected at '2'
 * Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 * <p>
 * Example 3:
 * <p>
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: No intersection
 * Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes of listA is in the m.
 * The number of nodes of listB is in the n.
 * 1 <= m, n <= 3 * 104
 * 1 <= Node.val <= 105
 * 0 <= skipA < m
 * 0 <= skipB < n
 * intersectVal is 0 if listA and listB do not intersect.
 * intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
 * <p>
 * <p>
 * Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory?
 */
public class Solution {

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        Set<ListNode> a = new HashSet<>();
        var current = headA;
        while (current != null) {
            a.add(current);
            current = current.next;
        }
        current = headB;
        while (current != null) {
            if (a.contains(current)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode result = null;
        var currentA = headA;
        var currentB = headB;
        while (currentA != null && currentB != null) {
            if (result == null) {
                if (currentA == currentB) {
                    result = currentA;
                    currentA = currentA.next;
                    currentB = currentB.next;
                } else {
                    currentB = currentB.next;
                }
            } else {
                if (currentA == currentB) {
                    currentA = currentA.next;
                    currentB = currentB.next;
                } else {
                    result = null;
                    currentB = currentB.next;
                }
            }
            if (currentA != null && currentB == null) {
                currentA = currentA.next;
                currentB = headB;
            }
        }
        return result;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        var currentA = headA;
        var currentB = headB;
        while (currentA != null && currentB != null) {
            if (currentA == currentB) {
                return currentA;
            } else {
                currentB = currentB.next;
            }
            if (currentB == null) {
                currentA = currentA.next;
                currentB = headB;
            }
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode current1 = headA;
        ListNode current2 = headB;
        while (current1 != current2) {
            current1 = current1 == null ? headB : current1.next;
            current2 = current2 == null ? headA : current2.next;
        }
        return current1;
    }
}
