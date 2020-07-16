/*
 * @lc app=leetcode.cn id=725 lang=cpp
 *
 * [725] 分隔链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution
{
public:
    vector<ListNode *> splitListToParts(ListNode *root, int k)
    {
        if (k == 0)
            return {root};
        if (root == nullptr)
            return vector<ListNode *>(k, nullptr); // k null vector when root==nullptr

        int n = 0;
        ListNode *curr = root;
        while (curr != nullptr)
        { // num of elements
            n++;
            curr = curr->next;
        }

        vector<ListNode *> result;
        int more_elem = (n % k); // Divide in buckets & see if starting elements req. more elements
        int bucket = n / k;

        curr = root;
        ListNode *prev = nullptr; // keep prev pointer to detatch

        while (curr != nullptr)
        {
            result.push_back(curr);
            int count = 0;
            while (count < bucket)
            {
                prev = curr;
                curr = curr->next;
                count++;
            }
            if (more_elem != 0)
            {
                prev = curr;
                curr = curr->next;
                more_elem--;
            }

            prev->next = nullptr;
        }

        while (result.size() < k) // keep adding nullptr till meet required k
            result.push_back(nullptr);

        return result;
    }
};
// @lc code=end
