/*
 * @lc app=leetcode.cn id=485 lang=cpp
 *
 * [485] 最大连续1的个数
 */

// @lc code=start
class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int value = 0;
        int maxConsecutivesOnes = 0;
        for (auto i : nums)
        {
            if (i == 1)
            {
                value++;
            }
            else
            {
                maxConsecutivesOnes = max(maxConsecutivesOnes,value);
                value = 0;
            }
            
            
        }
        if (value != 0)
        {
            maxConsecutivesOnes = max(maxConsecutivesOnes,value);
            
        }
        return maxConsecutivesOnes;
        
    }
};
// @lc code=end

