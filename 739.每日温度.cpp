/*
 * @lc app=leetcode.cn id=739 lang=cpp
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& nums) {
        vector<int> res(nums.size(),0);
        
        stack<int> s;

        for (int i = 0; i < nums.size() ; i++)
        {
            while (!s.empty() && nums[s.top()] < nums[i])
            {
                res[s.top()] = i - s.top();
                s.pop();
            }
            s.push(i);    
        }
        
        return res;
    }
};
// @lc code=end

