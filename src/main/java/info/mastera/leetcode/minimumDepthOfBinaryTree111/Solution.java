package info.mastera.leetcode.minimumDepthOfBinaryTree111;

import info.mastera.leetcode.TreeNode;

/**
 * 111. Minimum Depth of Binary Tree
 * Easy
 * <p>
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 105].
 * -1000 <= Node.val <= 1000
 */
public class Solution {

    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            return 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (null == root.left || null == root.right) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }
}
