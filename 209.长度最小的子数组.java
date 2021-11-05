import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;

        int sum = 0;
        int result = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j++];

            while (sum >= target) {
                result = Math.min(j - i, result);
                sum -= nums[i++];
            }

        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
// @lc code=end
