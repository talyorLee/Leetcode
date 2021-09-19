import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=451 lang=java
 *
 * [451] 根据字符出现频率排序
 */

// @lc code=start
class Solution {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        var c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            map.put(c[i], map.getOrDefault(c[i], 0) + 1);
        }
        Map<Integer, ArrayList<Character>> treeMap = new TreeMap<>((o1, o2) -> o2 - o1);



    }
}
// @lc code=end
