/*
 * @lc app=leetcode.cn id=392 lang=cpp
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
public:
    bool isSubsequence(string s, string t) {
        int i = 0;
        int j = 0;
        while (i<s.length()&&j<t.length())
        {
            if(s[i] == t[j])
            {
                i++;
                j++;
            }
            else
            {
                j++;
            }
            
        }
        return i == s.length();
        
        
    }
};
// @lc code=end

