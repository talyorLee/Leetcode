import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();

        inOrder(root, list, k);

        return list.get(k - 1);

    }

    public void inOrder(TreeNode root, List<Integer> list, int k) {
        if (root != null) {
            inOrder(root.left, list, k);

            list.add(root.val);

            inOrder(root.right, list, k);
        }

    }
}
// @lc code=end
