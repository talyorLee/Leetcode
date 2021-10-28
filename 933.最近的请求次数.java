import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=933 lang=java
 *
 * [933] 最近的请求次数
 */

// @lc code=start
class RecentCounter {

    int ping_num = 0;

    LinkedList<Integer> list = new LinkedList<>();

    public RecentCounter() {
        this.ping_num = 0;
    }

    public int ping(int t) {
        while (!list.isEmpty() && t - list.peekFirst() > 3000) {
            list.pollFirst();
        }
        list.add(t);
        return list.size();

    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter(); int param_1 = obj.ping(t);
 */
// @lc code=end
