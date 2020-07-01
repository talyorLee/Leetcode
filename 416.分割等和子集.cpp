/*
 * @lc app=leetcode.cn id=416 lang=cpp
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
public:
    bool canPartition(vector<int>& a) {
        int sum = 0;
        int n = a.size();
        
        for(int i=0; i<n; i++) 
            sum += a[i];
        
        if(sum%2 == 1)
            return false;
        
        sum /= 2;
        vector<vector<int>> dp(n+1,vector<int>(sum+1,0));
        
        for(int i=0; i<=n; i++)
            dp[i][0] = 0;
        
        for(int i=0; i<=sum; i++)
            dp[0][i] = 0;
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=sum; j++) {
                if(j-a[i-1] >= 0)
                    dp[i][j] = max(a[i-1] + dp[i-1][j-a[i-1]], dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[n][sum] == sum;
    }
};
// @lc code=end

