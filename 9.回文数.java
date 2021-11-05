/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        String result = String.valueOf(x);
        int i = 0;
        int j = result.length() - 1;
        while (i <= j) {
            if (result.charAt(i) != result.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
// @lc code=end
