/*
 * @lc app=leetcode.cn id=123 lang=cpp
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
#include <iostream>
#include <vector>
#include <cmath>
class Solution
{
public:
    int maxProfit(std::vector<int> &prices)
    {
        if (prices.size() == 0)
        {
            return 0;
        }

        std::vector<std::vector<std::vector<int> > > dp;

        dp.resize(prices.size());

        int max_k = 2;
        for (int i = 0; i < prices.size(); i++)
        {
            dp[i].resize(max_k + 1);
            dp[i][0].resize(2);
            //std::cout << "i=" << i << std::endl;
            for (int k = 1; k <= max_k; k++)
            {
                //std::cout << k << std::endl;
                dp[i][k].resize(2);
                if (i - 1 == -1)
                {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                }
                else
                {
                    dp[i][k][0] = std::max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                    dp[i][k][1] = std::max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                }
                //std::cout << dp[i][k][0] << " " << dp[i][k][1] << std::endl;
            }
        }
        return dp[prices.size() - 1][max_k][0];
    }
};
// @lc code=end
