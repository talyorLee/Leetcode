/*
 * @lc app=leetcode.cn id=110 lang=cpp
 *
 * [110] 平衡二叉树
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
    bool flag = true; 
    bool isBalanced(TreeNode *root)
    {
        depth(root);
        return flag;
    }
    int depth(TreeNode *root)
    {
        if (root != nullptr)
        {
            int l =depth(root->left);
            int r =depth(root->right);
            if(abs(l - r) > 1)
            {
                flag = false;
            }
            return max(l,r) + 1;
        }
        return 0;
        
    }
};
// @lc code=end
