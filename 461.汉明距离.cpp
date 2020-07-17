/*
 * @lc app=leetcode.cn id=461 lang=cpp
 *
 * [461] 汉明距离
 */

// @lc code=start
class Solution {
public:
    int hammingDistance(int x, int y) {
        int val = x ^ y;
        int res = 0;
        while (val!=0)
        {
            val = val & (val - 1);
            res++;
        }
        return res;
    }
};
// @lc code=end

