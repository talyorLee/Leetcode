/*
 * @lc app=leetcode.cn id=374 lang=java
 *
 * [374] 猜数字大小
 */

// @lc code=start
/**
 * Forward declaration of guess API.
 * 
 * @param num your guess
 * @return -1 if num is lower than the guess number 1 if num is higher than the
 *         guess number otherwise return 0 int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lower = 1, higher = n;
        int mid = 0, num = 0;
        while (lower <= higher) {
            mid = lower + (higher - lower) / 2;
            num = guess(mid);
            if (num == -1) {
                higher = mid - 1;
            } else if (num == 1) {
                lower = mid + 1;
            } else {
                return mid;
            }
        }
        return 0;

    }
}
// @lc code=end
