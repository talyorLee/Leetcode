import java.util.ArrayDeque;

/*
 * @lc app=leetcode.cn id=622 lang=java
 *
 * [622] 设计循环队列
 */

// @lc code=start
class MyCircularQueue {

    ArrayDeque<Integer> queue = new ArrayDeque<>();

    int k;

    public MyCircularQueue(int k) {
        this.k = k;
    }

    public boolean enQueue(int value) {
        if (queue.size() == k) {
            return false;
        }
        queue.addLast(value);
        return true;
    }

    public boolean deQueue() {
        if (queue.isEmpty())
            return false;
        queue.removeFirst();
        return true;

    }

    public int Front() {
        if (queue.isEmpty())
            return -1;
        return queue.peekFirst();
    }

    public int Rear() {
        if (queue.isEmpty())
            return -1;
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
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k); boolean param_1 =
 * obj.enQueue(value); boolean param_2 = obj.deQueue(); int param_3 =
 * obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
// @lc code=end
