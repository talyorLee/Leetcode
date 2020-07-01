/*
 * @lc app=leetcode.cn id=91 lang=cpp
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution
{
public:
    int numDecodings(string s)
    {
        int n = s.size();
        if (!n || s[0] == '0')
            return 0;
        int f0 = 1, f1 = 1, f2, i;
        for (i = 2; i <= n; ++i)
        {
            bool flag1 = false;
            bool flag2 = false;
            if (s[i - 1] != '0')
            {
                flag1=true;
            }
            if ((s[i - 2] == '1') || (s[i - 2] == '2' && s[i - 1] < '7'))
            {
                flag2=true;
            }
            //若该字符为非0且  前一个字符可分解的个数  加上    前两个字符可分解的个数
            //即以该字符单个结尾的个数 +  以该字符 加上 上一个字符  结尾的 个数
            f2 = (int)flag1 * f1 + (int)(flag2) * f0;
            f0 = f1;
            f1 = f2;
        }
        return f1;
    }
};
// @lc code=end
