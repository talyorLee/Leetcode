/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                if (tokens[i].equals("+")) {
                    result = num1 + num2;
                }
                if (tokens[i].equals("-")) {
                    result = num2 - num1;
                }
                if (tokens[i].equals("*")) {
                    result = num1 * num2;
                }
                if (tokens[i].equals("/")) {
                    result = num2 / num1;
                }
                stack.push(String.valueOf(result));
            } else {
                stack.push(tokens[i]);
            }
        }
        if (!stack.isEmpty())
            return Integer.parseInt(stack.pop());
        return result;

    }
}
// @lc code=end
