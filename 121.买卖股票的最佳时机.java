/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        if (prices.length == 1) {
            return 0;
        }
        // curMin record cur min stock value
        int curMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (curMin < prices[i]) {
                result = Math.max(result, prices[i] - curMin);
            } else {
                curMin = prices[i];
            }
        }
        return result;
    }
}
// @lc code=end
