/*
 * @lc app=leetcode.cn id=983 lang=java
 *
 * [983] 最低票价
 */

// @lc code=start
class Solution {
    public int mincostTickets(int[] days, int[] costs) {

        int len = days.length;
        int lastDay = days[len - 1];
        int[] hm = new int[366];
        for (int i : days) {
            hm[i]++;
        }
        // 到下标为 i 的这一天，旅行所需要的最低消费
        int[] dp = new int[lastDay + 1];
        for (int i = 1; i <= lastDay; i++) {
            if (hm[i] == 1) {
                dp[i] = min(dp[Math.max(0, i - 1)] + costs[0], dp[Math.max(0, i - 7)] + costs[1],
                        dp[Math.max(0, i - 30)] + costs[2]);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[lastDay];
    }

    public int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
// @lc code=end
