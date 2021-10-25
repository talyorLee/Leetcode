import java.util.Stack;
/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    Stack<String> stack = new Stack<>();

    public String simplifyPath(String path) {
        var paths = path.split("/");
        for (String pa : paths) {
            if (pa.equals("") || pa.equals(".")) {
                continue;
            } else if (pa.equals("..")) {
                if (stack.isEmpty() == false) {
                    stack.pop();
                } else {
                    continue;
                }
            } else {
                stack.push(pa);
            }
        }
        StringBuilder s = new StringBuilder();
        if (stack.isEmpty()) {
            s.insert(0, "/");
        }
        while (!stack.isEmpty()) {
            s.insert(0, stack.pop());
            s.insert(0, "/");
        }
        return s.toString();

    }
}
// @lc code=end
