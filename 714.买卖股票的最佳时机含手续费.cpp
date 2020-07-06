/*
 * @lc app=leetcode.cn id=714 lang=cpp
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution
{
public:
    int maxProfit(vector<int> &prices, int fee)
    {
        int dp_0 = 0;
        int dp_1 = 0;
        bool flag = false;
        for (int price : prices)
        {
            if (flag == false)
            {
                dp_0 = 0;
                dp_1 = -price - fee;
                flag = true;
            }
            else
            {
                dp_0 = max(dp_0, dp_1 + price);
                dp_1 = max(dp_1, dp_0 - price - fee);
            }
        }
        return dp_0;
    }
};
// @lc code=end
