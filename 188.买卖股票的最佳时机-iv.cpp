/*
 * @lc app=leetcode.cn id=188 lang=cpp
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
#include <iostream>
#include <vector>
#include <cmath>
class Solution
{
public:
    int maxProfit(int max_k, std::vector<int> &prices)
    {
        if (prices.size() == 0 || max_k == 0)
        {
            return 0;
        }
        if (max_k <= prices.size())
        {
            std::vector<std::vector<std::vector<int>>> dp;

            dp.resize(prices.size());

            for (int i = 0; i < prices.size(); i++)
            {
                dp[i].resize(max_k + 1);
                dp[i][0].resize(2);
                //std::cout << "i=" << i << std::endl;
                for (int k = 1; k <= max_k; k++)
                {
                    //std::cout << "k=" << k << std::endl;
                    dp[i][k].resize(2);
                    if (i - 1 == -1)
                    {
                        dp[i][k][0] = 0;
                        dp[i][k][1] = -prices[i];
                    }
                    else
                    {
                        //std::cout << k - 1 << std::endl;

                        dp[i][k][0] = std::max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                        dp[i][k][1] = std::max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                    }
                    //std::cout << dp[i][k][0] << " " << dp[i][k][1] << std::endl;
                }
            }
            return dp[prices.size() - 1][max_k][0];
        }
        else
        {
            int dp_0 = 0;
            int dp_1 = 0;
            bool flag = false;
            for (int price : prices)
            {
                if (flag == false)
                {
                    dp_0 = 0;
                    dp_1 = -price;
                    flag = true;
                }
                else
                {
                    dp_0 = max(dp_0, dp_1 + price);
                    dp_1 = max(dp_1, dp_0 - price);
                }
            }
            return dp_0;
        }
    }
};
// @lc code=end
