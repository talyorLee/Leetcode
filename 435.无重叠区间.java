import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        // for (int[] interval : intervals) {
        // System.out.println(Arrays.toString(interval));
        // }
        int result = 1;
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] >= intervals[index][1]) {
                result++;
                index = i;
            }
            // System.out.println(i + " " + result + " " + index);
            // System.out.println("==============");

        }
        return intervals.length - result;
    }
}
// @lc code=end
