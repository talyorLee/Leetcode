/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        // for example:
        // 左子树的可能*右子树的可能
        // dp[2]=dp[0]*dp[1] + dp[1]*dp[0]
        // dp[3]=dp[2]*dp[1] + dp[1]*dp[2]
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {

                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
// @lc code=end
