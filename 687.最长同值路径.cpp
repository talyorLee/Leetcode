/*
 * @lc app=leetcode.cn id=687 lang=cpp
 *
 * [687] 最长同值路径
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
    int path = 0;
    int dfs(TreeNode *root)
    {
        if (root == nullptr)
        {
            return 0;
        }
        int left = dfs(root->left);
        int right = dfs(root->right);
        if (root->left && root->val == root->left->val)
        {
            left += 1;
        }
        else
        {
            left = 0;
        }

        if (root->right && root->val == root->right->val)
        {
            right += 1;
        }
        else
        {
            right = 0;
        }
        path = max(path, left + right);
        return max(left, right);
    }
    int longestUnivaluePath(TreeNode *root)
    {
        dfs(root);
        return path;
    }
};
// @lc code=end
