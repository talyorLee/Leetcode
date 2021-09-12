import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null)
            return list;
        preorder(root, "", list);
        return list;
    }

    public void preorder(TreeNode root, String pre, List<String> res) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                res.add(pre + root.val);
            }
            if (root.left != null) {
                preorder(root.left, pre + root.val + "->", res);
            }
            if (root.right != null) {
                preorder(root.right, pre + root.val + "->", res);
            }
        }
    }
}
// @lc code=end
