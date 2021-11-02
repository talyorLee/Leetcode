import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Record the number of occurrences of each number
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : nums1) {
            if (map.containsKey(e)) {
                map.put(e, map.get(e) + 1);
            } else {
                map.put(e, 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int e : nums2) {
            // when we find the same num in num2,we add num to result
            // update map[key]
            // when map[key] is equal to 0 ,it means result has the same number of key
            // and even if num2 has more key, result should not add key.
            if (map.containsKey(e) && map.get(e) >= 1) {
                result.add(e);
                map.put(e, map.get(e) - 1);
            }
        }
        int[] s = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            s[i] = result.get(i);
        }
        return s;
    }
}
// @lc code=end
