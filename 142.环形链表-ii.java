/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        var slow = head;
        var fast = head;
        // if the list don't hasCycle , the while cycle must be end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        // 特判，如果只是因为链表不存在环，那就返回空，因为既然不存在环，肯定没有重复结点
        if (fast == null || fast.next == null) {
            return null;
        }
        // TODO
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
// @lc code=end
