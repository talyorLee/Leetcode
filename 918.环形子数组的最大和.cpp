/*
 * @lc app=leetcode.cn id=918 lang=cpp
 *
 * [918] 环形子数组的最大和
 */

// @lc code=start

class Solution
{
public:
    int maxSubarraySumCircular(vector<int> &A)
    {
        int N = A.size();

        int ans = A[0], cur = A[0];
        for (int i = 1; i < N; ++i)
        {
            cur = A[i] + max(cur, 0);
            ans = max(ans, cur);
        }

        // ans is the answer for 1-interval subarrays.
        // Now, let's consider all 2-interval subarrays.
        // For each i, we want to know
        // the maximum of sum(A[j:]) with j >= i+2

        // rightsums[i] = A[i] + A[i+1] + ... + A[N-1]
        vector<int> rightsums(N,0);
        rightsums[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; --i)
            rightsums[i] = rightsums[i + 1] + A[i];

        // maxright[i] = max_{j >= i} rightsums[j]
        vector<int> maxright(N,0);
        maxright[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; --i)
            maxright[i] = max(maxright[i + 1], rightsums[i]);

        int leftsum = 0;
        for (int i = 0; i < N - 2; ++i)
        {
            leftsum += A[i];
            ans = max(ans, leftsum + maxright[i + 2]);
        }

        return ans;
    }
};
// @lc code=end