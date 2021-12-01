import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] result = intervals;
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] <= result[index][1]) {
                result[index][0] = result[index][0];
                result[index][1] = Math.max(result[index][1], intervals[i][1]);
            } else {
                result[++index] = intervals[i];
            }
        }
        return Arrays.copyOf(result, index + 1);

    }
}
// @lc code=end
