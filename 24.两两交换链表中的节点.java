/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 这里设置 dummyNode 是为了处理头结点的特殊情况
        // 使得头结点和非头结点可以统一处理
        var dummyNode = new ListNode(-1);
        dummyNode.next = head;
        var curNode = dummyNode;

        while (curNode.next != null && curNode.next.next != null) {
            // 重新初始化 p1 和 p2
            var p1 = curNode.next;
            var p2 = p1.next;

            // 穿针引线的步骤就 3 步
            p1.next = p2.next;
            p2.next = p1;
            curNode.next = p2;

            // 循环变量更新
            curNode = p1;
        }
        return dummyNode.next;
    }
}
// @lc code=end
