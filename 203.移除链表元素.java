import javax.lang.model.util.ElementScanner6;

/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode cur = node;
        while (cur.next != null) {
            if (cur.next.val == val) {
                var deleteNode = cur.next;
                cur.next = cur.next.next;
                deleteNode.next = null;
            } else {
                cur = cur.next;
            }

        }
        return node.next;
    }
}
// @lc code=end
