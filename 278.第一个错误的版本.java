/*
 * @lc app=leetcode.cn id=278 lang=java
 *
 * [278] 第一个错误的版本
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lower = 1, higher = n;

        int result = 0;
        while (lower <= higher) {
            int mid = lower + (higher - lower) / 2;
            if (isBadVersion(mid) == false) {
                lower = mid + 1;
            } else {
                higher = mid - 1;
                result = mid;
            }
        }
        return result;
    }
}
// @lc code=end
