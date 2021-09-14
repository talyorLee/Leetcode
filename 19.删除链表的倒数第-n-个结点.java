/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        var dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode node = dummyNode;
        ListNode nodePre = dummyNode;
        for (int i = 0; i < n; i++) {
            node = node.next;
            if (node == null) {
                return null;
            }
        }

        while (node.next != null) {
            node = node.next;
            nodePre = nodePre.next;
        }

        ListNode deleteNode = nodePre.next;

        nodePre.next = deleteNode.next;

        deleteNode.next = null;

        return dummyNode.next;
    }
}
// @lc code=end
