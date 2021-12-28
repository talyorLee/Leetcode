/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    // solutions for binary tree
    // first: find the p or q in left tree and right tree
    // second: if the left tree and the right tree exist p or q,then it means one in
    // left , one in right tree
    // so the root should be the ancestor of p and q
    // final: if the left tree or the right tree is null,
    // it means p and q are exist in one side , so first returned node is the
    // ancestor of p and q
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        var left = lowestCommonAncestor(root.left, p, q);
        var right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }
}
// @lc code=end
