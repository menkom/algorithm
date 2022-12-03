package info.mastera.leetcode.convertSortedArrayToBinarySearchTree108;

import java.util.Arrays;
import java.util.Objects;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * Easy
 * 8.7K
 * 434
 * Companies
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a
 * height-balanced
 * binary search tree.
 * <p>
 * Example 1:
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 * <p>
 * Example 2:
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 * <p>
 * <p>
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 * <p>
 * <p>
 * <a href="https://www.geeksforgeeks.org/introduction-to-height-balanced-binary-tree/">Explanation of Height balanced binary tree</a>
 */
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        var middle = nums.length / 2;

        return new TreeNode(
                nums[middle],
                sortedArrayToBST(Arrays.copyOfRange(nums, 0, middle)),
                sortedArrayToBST(Arrays.copyOfRange(nums, middle + 1, nums.length))
        );
    }

    public TreeNode sortedArrayToBST1(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int from, int to) {
        if (to < from) {
            return null;
        }
        if (to - from == 0) {
            return new TreeNode(nums[from]);
        }
        var middle = (to - from) / 2;

        return new TreeNode(
                nums[from + middle],
                sortedArrayToBST(nums, from, from + middle - 1),
                sortedArrayToBST(nums, from + middle + 1, to)
        );
    }
}
