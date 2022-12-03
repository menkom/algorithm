package info.mastera.leetcode.convertSortedArrayToBinarySearchTree108;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    public void test() {
        //[0,-3,9,-10,null,5]
        var test = new Solution.TreeNode(0);
        test.left = new Solution.TreeNode(-3);
        test.left.left = new Solution.TreeNode(-10);
        test.right = new Solution.TreeNode(9);
        test.right.left = new Solution.TreeNode(5);
        var toTest = new Solution().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        assertEquals(test, toTest);

//        test = new Solution.TreeNode(3);
//        test.left = new Solution.TreeNode(1);
//        assertEquals(test, new Solution().sortedArrayToBST(new int[]{1, 3}));
//
//        test = new Solution.TreeNode(3);
//        test.left = new Solution.TreeNode(1);
//        test.right = new Solution.TreeNode(5);
//        assertEquals(test, new Solution().sortedArrayToBST(new int[]{1, 3, 5}));
    }
}