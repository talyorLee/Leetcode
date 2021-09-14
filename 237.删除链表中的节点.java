/*
 * @lc app=leetcode.cn id=237 lang=java
 *
 * [237] 删除链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;

        // 第 2 步：删除下一个结点
        node.next = nextNode.next;
        nextNode.next = null;
    }
}
// @lc code=end
