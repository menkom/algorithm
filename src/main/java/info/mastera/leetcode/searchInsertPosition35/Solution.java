package info.mastera.leetcode.searchInsertPosition35;

/**
 * 35. Search Insert Position
 * Easy
 * 10.6K
 * 499
 * Companies
 * <p>
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You mustwrite an algorithm withO(log n) runtime complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums contains distinct values sorted in ascending order.
 * -104 <= target <= 104
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        return getPosition(nums, target, 0, nums.length - 1);
    }

    private int getPosition(int[] nums, int target, int from, int to) {
        if (from == to) {
            return target <= nums[from] ? from : from + 1;
        } else {
            int middleIndex = getMiddle(from, to);
            if (nums[middleIndex] == target) {
                return middleIndex;
            } else {
                return target < nums[middleIndex]
                        ? getPosition(nums, target, from, middleIndex - 1)
                        : getPosition(nums, target, Math.min(to, middleIndex + 1), to);
            }
        }
    }

    private boolean isEven(int value) {
        return (value & 1) == 0;
    }

    private int getMiddle(int from, int to) {
        int length = to - from;
        return from + (length + 1) / 2 + (isEven(length + 1) ? 0 : 1);
    }
}
