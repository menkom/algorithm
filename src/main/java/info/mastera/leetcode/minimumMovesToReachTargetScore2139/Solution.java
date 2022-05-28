package info.mastera.leetcode.minimumMovesToReachTargetScore2139;

/**
 * 2139. Minimum Moves to Reach Target Score
 * Medium
 * <p>
 * You are playing a game with integers. You start with the integer 1 and you want to reach the integer target.
 * <p>
 * In one move, you can either:
 * <p>
 * Increment the current integer by one (i.e., x = x + 1).
 * Double the current integer (i.e., x = 2 * x).
 * <p>
 * You can use the increment operation any number of times, however, you can only use the double operation at most maxDoubles times.
 * <p>
 * Given the two integers target and maxDoubles, return the minimum number of moves needed to reach target starting with 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = 5, maxDoubles = 0
 * Output: 4
 * Explanation: Keep incrementing by 1 until you reach target.
 * <p>
 * Example 2:
 * <p>
 * Input: target = 19, maxDoubles = 2
 * Output: 7
 * Explanation: Initially, x = 1
 * Increment 3 times so x = 4
 * Double once so x = 8
 * Increment once so x = 9
 * Double again so x = 18
 * Increment once so x = 19
 * <p>
 * Example 3:
 * <p>
 * Input: target = 10, maxDoubles = 4
 * Output: 4
 * Explanation: Initially, x = 1
 * Increment once so x = 2
 * Double once so x = 4
 * Increment once so x = 5
 * Double again so x = 10
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= target <= 109
 * 0 <= maxDoubles <= 100
 */
public class Solution {

    public int minMoves(int target, int maxDoubles) {
        int stepsPassed = 0;
        while (target != 1) {
            if (maxDoubles == 0) {
                return target - 1 + stepsPassed;
            }
            if ((target & 1) == 1) {
                target--;
            } else {
                target >>=1;
                maxDoubles--;
            }
            stepsPassed++;
        }
        return stepsPassed;
    }

    public int minMoves1(int target, int maxDoubles) {
        int stepsPassed = 0;
        while (target != 1) {
            if (maxDoubles == 0) {
                return target - 1 + stepsPassed;
            }
            if (target % 2 == 0) {
                target = target / 2;
                maxDoubles--;
            } else {
                target--;
            }
            stepsPassed++;
        }
        return stepsPassed;
    }
}
