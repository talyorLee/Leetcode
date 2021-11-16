import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=436 lang=java
 *
 * [436] 寻找右区间
 */

// @lc code=start
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> startPoints = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            startPoints.put(intervals[i][0], i);
        }

        int[] ans = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            Integer nextClosestStartPoint = startPoints.ceilingKey(intervals[i][1]);
            ans[i] = nextClosestStartPoint == null ? -1 : startPoints.get(nextClosestStartPoint);
        }
        return ans;
    }
}
// @lc code=end
