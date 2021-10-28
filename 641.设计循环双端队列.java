import java.util.ArrayDeque;

/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
class MyCircularDeque {
    ArrayDeque<Integer> queue = new ArrayDeque<>();

    int k;

    public MyCircularDeque(int k) {
        this.k = k;
    }

    public boolean insertFront(int value) {
        if (queue.size() == k) {
            return false;
        }
        queue.addFirst(value);
        return true;

    }

    public boolean insertLast(int value) {
        if (queue.size() == k) {
            return false;
        }
        queue.addLast(value);
        return true;

    }

    public boolean deleteFront() {
        if (queue.size() == 0) {
            return false;
        }
        queue.pollFirst();
        return true;

    }

    public boolean deleteLast() {
        if (queue.size() == 0) {
            return false;
        }
        queue.pollLast();
        return true;

    }

    public int getFront() {
        if (queue.size() == 0) {
            return -1;
        }
        return queue.peekFirst();
    }

    public int getRear() {
        if (queue.size() == 0) {
            return -1;
        }
        return queue.peekLast();

    }

    public boolean isEmpty() {
        return queue.isEmpty();

    }

    public boolean isFull() {
        return queue.size() == k;

    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k); boolean param_1 =
 * obj.insertFront(value); boolean param_2 = obj.insertLast(value); boolean
 * param_3 = obj.deleteFront(); boolean param_4 = obj.deleteLast(); int param_5
 * = obj.getFront(); int param_6 = obj.getRear(); boolean param_7 =
 * obj.isEmpty(); boolean param_8 = obj.isFull();
 */
// @lc code=end
