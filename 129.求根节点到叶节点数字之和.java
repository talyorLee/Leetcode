/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根节点到叶节点数字之和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<String> list = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        setNumbers(root, "");
        var sum = 0;
        for (String s : list) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    public void setNumbers(TreeNode root, String path) {
        if (root != null) {
            path = path + root.val;
            if (root.left == null && root.right == null) {
                list.add(path);
            }
            setNumbers(root.left, path);
            setNumbers(root.right, path);
        }
        return;
    }

}
// @lc code=end
