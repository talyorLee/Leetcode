/*
 * @lc app=leetcode.cn id=543 lang=cpp
 *
 * [543] 二叉树的直径
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution
{
public:
    int result = 0;
    int depth(TreeNode *root)
    {
        if (root != nullptr)
        {
            int l = depth(root->left);
            int r = depth(root->right);
            result = max(result,l+r);
            return max(l,r) + 1;
        }
        return 0;
    }
    int diameterOfBinaryTree(TreeNode *root)
    {
        depth(root);
        return result;
    }
};
// @lc code=end
