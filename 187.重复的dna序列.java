import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();

        int len = s.length();
        for (int i = 0; i + 9 < len; i++) {
            String segment = s.substring(i, i + 10);
            if (!seen.add(segment)) {
                repeated.add(segment);
            }
        }
        return new ArrayList<>(repeated);
    }
}
// @lc code=end
