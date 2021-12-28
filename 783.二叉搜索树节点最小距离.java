import java.util.ArrayList;
import java.util.List;

`/*
 * @lc app=leetcode.cn id=783 lang=java
 *
 * [783] 二叉搜索树节点最小距离
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> list = new ArrayList<>();

    public void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }

    }

    public int minDiffInBST(TreeNode root) {
        inorder(root,list);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            minDiff = Math.min(minDiff, list.get(i)-list.get(i-1));
        }
        return minDiff;
    }
}
// @lc code=end
