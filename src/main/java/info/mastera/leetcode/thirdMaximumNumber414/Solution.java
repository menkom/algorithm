package info.mastera.leetcode.thirdMaximumNumber414;

import java.util.Arrays;

/**
 * 414. Third Maximum Number
 * Easy
 * 2.2K
 * 2.6K
 * Companies
 * Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2.
 * The third distinct maximum is 1.
 * Example 2:
 * <p>
 * Input: nums = [1,2]
 * Output: 2
 * Explanation:
 * The first distinct maximum is 2.
 * The second distinct maximum is 1.
 * The third distinct maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * <p>
 * Input: nums = [2,2,3,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2 (both 2's are counted together since they have the same value).
 * The third distinct maximum is 1.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * <p>
 * Follow up: Can you find an O(n) solution?
 */
public class Solution {

    static class Result {

        Integer[] answer = new Integer[3];

        int getAnswer() {
            System.out.println(Arrays.toString(answer));
            if (answer[2] != null) {
                return answer[2];
            }
            return answer[0];
        }

        void add(int value) {
            add(value, 0);
        }

        void add(int value, int position) {
            if (position < 3) {
                if (answer[position] == null) {
                    answer[position] = value;
                } else {
                    if (answer[position] != value) {
                        if (value > answer[position]) {
                            add(answer[position], position + 1);
                            answer[position] = value;
                        } else {
                            add(value, position + 1);
                        }
                    }
                }
            }
        }
    }

    public int thirdMax(int[] nums) {
        var result = new Result();
        for (int value : nums) {
            result.add(value);
        }
        return result.getAnswer();
    }
}
