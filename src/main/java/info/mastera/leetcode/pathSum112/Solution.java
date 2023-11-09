package info.mastera.leetcode.pathSum112;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 112. Path Sum
 * Easy
 * <p>
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 * <p>
 * A leaf is a node with no children.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is shown.
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * Explanation: There two root-to-leaf paths in the tree:
 * (1 --> 2): The sum is 3.
 * (1 --> 3): The sum is 4.
 * There is no root-to-leaf path with sum = 5.
 * Example 3:
 * <p>
 * Input: root = [], targetSum = 0
 * Output: false
 * Explanation: Since the tree is empty, there are no root-to-leaf paths.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }
        if (null == root.left && null == root.right) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }

    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }
        int sum = root.val;
        if (null == root.left && null == root.right) {
            return sum == targetSum;
        } else {
            Queue<Pair<TreeNode, Integer>> queue =
                    new ArrayDeque<>();
            if (null != root.left) {
                queue.add(new Pair<>(root.left, sum));
            }
            if (null != root.right) {
                queue.add(new Pair<>(root.right, sum));
            }
            return hasPathSum(queue, targetSum);
        }
    }

    private boolean hasPathSum(Queue<Pair<TreeNode, Integer>> queue, int targetSum) {
        if (queue.isEmpty()) {
            return false;
        }
        Pair<TreeNode, Integer> current = queue.poll();
        var node = current.key;
        var sum = current.value;

        if (null == node.left && null == node.right) {
            if (targetSum - sum - node.val == 0) {
                return true;
            }
            return hasPathSum(queue, targetSum);
        } else {
            if (null != node.left) {
                queue.add(new Pair<>(node.left, node.val + sum));
            }
            if (null != node.right) {
                queue.add(new Pair<>(node.right, node.val + sum));
            }
            return hasPathSum(queue, targetSum);
        }
    }

    static class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
