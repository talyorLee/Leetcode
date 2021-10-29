/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int pre = 0;
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
