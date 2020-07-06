/*
 * @lc app=leetcode.cn id=309 lang=cpp
 *
 * [309] 最佳买卖股票时机含冷冻期
 */

// @lc code=start
class Solution
{
public:
    int maxProfit(vector<int> &prices)
    {
        int dp_0 = 0;
        int dp_1 = 0;
        int dp_pre_0 = 0;
        for (int i = 0; i < prices.size(); i++)
        {
            if (i == 0)
            {
                dp_0 = 0;
                dp_1 = -prices[i];
            }
            else
            {
                int a = dp_0;
                dp_0 = max(dp_0, dp_1 + prices[i]);
                dp_1 = max(dp_1, dp_pre_0 - prices[i]);
                dp_pre_0 = a;
            }
        }
        return dp_0;
    }
};
// @lc code=end
