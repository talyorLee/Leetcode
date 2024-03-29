/*
 * @lc app=leetcode.cn id=605 lang=cpp
 *
 * [605] 种花问题
 */

// @lc code=start
class Solution
{
public:
    bool canPlaceFlowers(vector<int> &flowerbed, int n)
    {
        int len = flowerbed.size();
        int cnt = 0;
        for (int i = 0; i < len && cnt < n; i++)
        {
            if (flowerbed[i] == 1)
            {
                continue;
            }
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == len - 1 ? 0 : flowerbed[i + 1];
            if (pre == 0 && next == 0)
            {
                cnt++;
                flowerbed[i] = 1;
            }
        }
        return cnt >= n;
    }
};
// @lc code=end
