/*
 * @lc app=leetcode.cn id=763 lang=cpp
 *
 * [763] 划分字母区间
 */

// @lc code=start
class Solution
{
public:
    vector<int> partitionLabels(string S)
    {
        int N = S.size();
        vector<int> ends(26, -1);
        for (int i = 0; i < N; ++i)
        {
            ends[S[i] - 'a'] = i;
        }
        vector<int> res;
        int i = 0;
        while (i < N)
        {
            int r = ends[S[i] - 'a'];
            for (int j = i + 1; j <= r; ++j)
            {
                r = max(r, ends[S[j] - 'a']);
            }
            res.push_back(r - i + 1);
            i = r + 1;
        }
        return res;
    }
};
// @lc code=end
