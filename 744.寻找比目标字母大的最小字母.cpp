/*
 * @lc app=leetcode.cn id=744 lang=cpp
 *
 * [744] 寻找比目标字母大的最小字母
 */

// @lc code=start
class Solution
{
public:
    char nextGreatestLetter(vector<char> &letters, char target)
    {
        int n = letters.size();
        int l = 0, h = n - 1;
        while (l <= h)
        {
            int m = l + (h - l) / 2;
            if (letters[m] <= target)
            {
                l = m + 1;
            }
            else
            {
                h = m - 1;
            }
        }
        return l < n ? letters[l] : letters[0];
    }
};
// @lc code=end
