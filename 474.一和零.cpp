/*
 * @lc app=leetcode.cn id=474 lang=cpp
 *
 * [474] 一和零
 */

// @lc code=start
class Solution
{
public:
    int findMaxForm(vector<string> &strs, int m, int n)
    {
        if (strs.size() == 0)
        {
            return 0;
        }
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));
        for (string s : strs)
        { // 每个字符串只能用一次
            int ones = 0, zeros = 0;
            for (char c : s)
            {
                if (c == '0')
                {
                    zeros++;
                }
                else
                {
                    ones++;
                }
            }
            for (int i = m; i >= zeros; i--)
            {
                for (int j = n; j >= ones; j--)
                {
                    dp[i][j] = max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
};
// @lc code=end
