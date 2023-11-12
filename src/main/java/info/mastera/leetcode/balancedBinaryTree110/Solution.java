package info.mastera.leetcode.balancedBinaryTree110;

import info.mastera.leetcode.TreeNode;

/**
 * 110. Balanced Binary Tree
 * <p>
 * Easy
 * <p>
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: root = []
 * Output: true
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 5000].
 * -104 <= Node.val <= 104
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (null == root || (null == root.left && null == root.right)) {
            return true;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(final TreeNode node) {
        if (null == node) {
            return 0;
        }
        if (null == node.left && null == node.right) {
            return 1;
        }
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return Math.max(left, right) + 1;
    }
}
