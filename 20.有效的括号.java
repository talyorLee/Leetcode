/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty() == true) {
                    return false;
                }
                char c = stack.pop();
                if (c == '(' && s.charAt(i) != ')')
                    return false;
                if (c == '[' && s.charAt(i) != ']')
                    return false;
                if (c == '{' && s.charAt(i) != '}')
                    return false;

            }

        }
        return stack.isEmpty();

    }
}
// @lc code=end
