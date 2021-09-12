/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        sumOfLeftLeaves2(root);
        return sum;
    }

    public void sumOfLeftLeaves2(TreeNode root) {
        if (root != null) {
            // if (isLeftLeaves(root) == true)
            // sum += root.left.val;
            if (isLeaves(root.left)) {
                sum += root.left.val;
            }
            sumOfLeftLeaves(root.left);
            sumOfLeftLeaves(root.right);
        }
    }

    public boolean isLeftLeaves(TreeNode root) {
        if (root != null) {
            if (root.left != null && root.left.left == null && root.left.right == null) {
                return true;
            }
        }
        return false;
    }

    public boolean isLeaves(TreeNode root) {
        if (root == null)
            return false;

        return root.left == null && root.right == null;
    }
}
// @lc code=end
