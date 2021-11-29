/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        int lower = 1, higher = x / 2;
        while (lower < higher) {
            int mid = lower + (higher - lower + 1) / 2;

            if ((x / mid) < mid) {
                higher = mid - 1;
            } else {
                lower = mid;
            }
        }
        return lower;

    }
}
// @lc code=end
