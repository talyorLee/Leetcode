/*
 * @lc app=leetcode.cn id=646 lang=cpp
 *
 * [646] 最长数对链
 */

// @lc code=start
class Solution {
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        if (pairs.size() == 0)
        {
            return 0;
        }
        int n = pairs.size();
        vector<int> dp(n, 0);
        dp[0] = 1;
        sort(pairs.begin(),pairs.end());
        for (size_t i = 1; i < n; i++)
        {
            for (size_t j = 0; j < i; j++)
            {
                if (pairs[i][0] > pairs[j][1] && dp[i] < dp[j])
                {
                    dp[i] = dp[j];
                }
            }
            dp[i] += 1;
        }
        int max_length = 1;
        for (size_t i = 0; i < n; i++)
        {
            if (max_length < dp[i])
            {
                max_length = dp[i];
            }
        }
        return max_length;
    }
};
// @lc code=end

