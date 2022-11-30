package info.mastera.leetcode.bestTimeToBuyAndSellStock121;

/**
 * 121. Best Time to Buy and Sell Stock
 * Easy
 * 21.6K
 * 689
 * Companies
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 * <p>
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class Solution {

    public int maxProfit1(int[] prices) {
        var maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i] && maxProfit < prices[j] - prices[i]) {
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        var maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    maxProfit = Integer.max(prices[j] - prices[i], maxProfit);
                }
            }
        }
        return maxProfit;
    }

    public int maxProfit3(int[] prices) {
        var maxProfit = 0;
        var maxValue = prices[prices.length - 1];
        for (int i = prices.length - 1; i >= 0; i--) {
            if (maxValue - prices[i] > maxProfit) {
                maxProfit = maxValue - prices[i];
            }
            if (maxValue < prices[i]) {
                maxValue = prices[i];
            }
        }
        return maxProfit;
    }

    //most fast
    public int maxProfit0(int[] prices) {
        var maxProfit = 0;
        var maxValue = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            if (maxValue < prices[i]) {
                maxValue = prices[i];
            } else {
                maxProfit = Integer.max(maxProfit, maxValue - prices[i]);
            }
        }
        return maxProfit;
    }

    //alternative most fast
    public int maxProfit(int[] prices) {
        var maxProfit = 0;
        var minValue = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (minValue > prices[i]) {
                minValue = prices[i];
            } else {
                maxProfit = Integer.max(maxProfit, prices[i] - minValue);
            }
        }
        return maxProfit;
    }
}
