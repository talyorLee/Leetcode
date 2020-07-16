/*
 * @lc app=leetcode.cn id=565 lang=cpp
 *
 * [565] 数组嵌套
 */

// @lc code=start
class Solution {
public:
    int arrayNesting(vector<int>& nums) {
        int length = 0;
        for (size_t i = 0; i < nums.size(); i++)
        {
            int cnt = 0;
            for (size_t j = i; nums[j] != -1; )
            {
                int t = nums[j];
                nums[j] = -1;
                j = t;
                cnt++;
            }
            length = max(length,cnt);
            
        }
        return length;

    }
};
// @lc code=end

