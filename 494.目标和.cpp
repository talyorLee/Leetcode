/*
 * @lc app=leetcode.cn id=494 lang=cpp
 *
 * [494] 目标和
 */

// @lc code=start
class Solution
{
public:
    int findTargetSumWays(vector<int> &nums, int S)
    {
        int sum = computeArraySum(nums);
        if (sum < S || (sum + S) % 2 == 1)
        {
            return 0;
        }
        int W = (sum + S) / 2;
        vector<int> dp(W + 1, 0);
        dp[0] = 1;
        for (int num : nums)
        {
            for (int i = W; i >= num; i--)
            {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[W];
    }
    int computeArraySum(vector<int> &nums)
    {
        int sum = 0;
        for (int num : nums)
        {
            sum += num;
        }
        return sum;
    }
};
// @lc code=end
