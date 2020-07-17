/*
 * @lc app=leetcode.cn id=451 lang=cpp
 *
 * [451] 根据字符出现频率排序
 */

// @lc code=start
class Solution
{
public:
    string frequencySort(string s)
    {
        string res = "";
        unordered_map<char, int> m;
        for (auto c : s)
            m[c]++;
        map<int, vector<char>> m_map;

        for (auto i : m)
        {
            m_map[i.second].push_back(i.first);
        }

        for (auto i : m_map)
        {

            for (auto e : i.second)
            {
                string str(i.first, e);
                res = str + res;
            }
        }
        return res;
    }
};
// @lc code=end
