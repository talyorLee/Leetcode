/*
 * @lc app=leetcode.cn id=503 lang=cpp
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start
#include <stack>
class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        vector<int> res(nums.size(),-1);
        // stack<int> m_stack;
        // for (int i = 2 * nums.size() - 1; i >= 0; --i) {
        //     while (!m_stack.empty() && nums[m_stack.top()] <= nums[i % nums.size()]) {
        //         m_stack.pop();
        //     }
        //     res[i % nums.size()] = m_stack.empty() ? -1 : nums[m_stack.top()];
        //     m_stack.push(i % nums.size());
        // }
        stack<int> s;

        for (int i = 0; i < nums.size() * 2 ; i++)
        {
            while (!s.empty() && nums[s.top()] < nums[i%nums.size()])
            {
                res[s.top()] = nums[i%nums.size()];
                s.pop();
            }
            s.push(i%nums.size());    
        }
        // for (size_t i = 0; i < nums.size()-1; i++)
        // {
        //     if(nums[i]> nums[nums.size()-1])
        //     {
        //         res[nums.size()-1] = nums[i];
        //         break;
        //     }
        // }
        
        return res;
    }
};
// @lc code=end

