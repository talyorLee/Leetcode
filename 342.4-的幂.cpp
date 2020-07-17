/*
 * @lc app=leetcode.cn id=342 lang=cpp
 *
 * [342] 4的幂
 */

// @lc code=start
class Solution
{
public:
    bool isPowerOfFour(int num)
    {
        //num & (num-1):if num has a binary representation as ****10...0,
        //                               then num - 1 will be ****01...1 in binary,
        //                          and num & (num-1) will be ****00...0 in binary.
        //i.e. find the first '1' and set it as '0'
        //if num & (num-1) equals 0,it means that there is one and only one bit in num's binary representation.
        //0x55555555's binary representation is :1010101010101010101010101010101
        //1010101010101010101010101010101=4^15 + 4^14 + ... + 4^2 + 4^1 + 4^0,here '^' means power
        //if num & 0x55555555 not equals 0,meaning that there is at least one bit in num's binary representation
        //if num meets the above conditions,meaning that it is  a power of 4.


        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
};
// @lc code=end
