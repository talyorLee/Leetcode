/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        int pre = 1;
        int cur = 1;
        for (int i = 2; i <= n; i++) {
            int t = cur;
            cur = pre + cur;
            pre = t;
        }
        return cur;
    }
}
// @lc code=end
