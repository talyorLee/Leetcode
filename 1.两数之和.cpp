/*
 * @lc app=leetcode.cn id=1 lang=cpp
 *
 * [1] 两数之和
 */

// @lc code=start
#include <map>
class Solution
{
public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        map<int,int> m_map;
        for (int i = 0; i < nums.size(); i++)
        {
            int complement = target - nums[i];
            if (m_map.find(complement) != m_map.end())
            {
                return {m_map[complement], i};
            }
            m_map[nums[i]]= i;
        }
        return {};
    }
};
// @lc code=end
