package info.mastera.leetcode.addTwoNumbers2;

import java.util.Arrays;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

//    ListNode(int val) {
//        this.val = val;
//    }

    ListNode(int... val) {
        this.val = val[0];
        if (val.length > 1) {
            this.next = new ListNode(Arrays.copyOfRange(val, 1, val.length));
        }
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        var that = (ListNode) obj;
        return this.val == that.val && (this.next == that.next || this.next.equals(that.next));
    }
}
