import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=525 lang=java
 *
 * [525] 连续数组
 */

// @lc code=start
class Solution {
    public int findMaxLength(int[] nums) {
        /**
         * At every index, add to the current sum,
         * and put the current sum in a hashmap with the index.
         * Now, if we encounter the current sum value somewhere else in the future,
         * it means that there were equal number of zeros and ones in between the two
         * indices,
         * so that is the length.
         * Because zero does not contribute to the sum, we add -1 instead to count zeros
         * within the sum.
         */
        int maxLen = 0;
        int curSum = 0;
        Map<Integer, Integer> track = new HashMap<>();

        track.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i] == 0 ? -1 : nums[i];

            if (track.containsKey(curSum)) {
                maxLen = Math.max(maxLen, i - track.get(curSum));
            } else {
                track.put(curSum, i);
            }

        }
        return maxLen;
    }
}
// @lc code=end
