#include <vector>
#include <algorithm>

using namespace std;

// https://leetcode.com/problems/maximum-subarray/solutions/1595195/c-python-7-simple-solutions-w-explanation-brute-force-dp-kadane-divide-conquer

// Brute Force - TLE
// 가능한 모든 subarray의 합을 계산하여 최대값 찾기
class Solution
{
public:
    int maxSubArray(vector<int> &nums)
    {
        int n = size(nums), ans = INT_MIN;
        for (int i = 0; i < n; i++)
            for (int j = i, curSum = 0; j < n; j++)
                curSum += nums[j],
                    ans = max(ans, curSum);
        return ans;
    }
};

// Recursive - TLE
// 가능한 모든 부분 배열을 재귀적으로 탐색하여 최대 합 찾기
class Solution2
{
public:
    int maxSubArray(vector<int> &nums)
    {
        return solve(nums, 0, false);
    }
    int solve(vector<int> &A, int i, bool mustPick)
    {
        // 우리의 부분 배열은 최소한 1개의 요소를 포함해야 합니다. 만약 끝에서 mustPick이 false라면 선택된 요소가 없다는 의미이며 이는 유효하지 않은 경우입니다.
        if (i >= size(A))
            return mustPick ? 0 : -1e5;
        if (mustPick)
            return max(0, A[i] + solve(A, i + 1, true));                  // 여기서 멈추거나 현재 요소를 선택하고 재귀를 계속합니다.
        return max(solve(A, i + 1, false), A[i] + solve(A, i + 1, true)); // 현재 요소를 선택하거나 선택하지 않는 두 가지 경우를 모두 시도합니다.
    }
};

// DP
// 재귀 함수에 메모이제이션을 추가하여 중복 계산 방지
class Solution3
{
public:
    int maxSubArray(vector<int> &nums)
    {
        vector<vector<int>> dp(2, vector<int>(size(nums), -1));
        return solve(nums, 0, false, dp);
    }
    int solve(vector<int> &A, int i, bool mustPick, vector<vector<int>> &dp)
    {
        if (i >= size(A))
            return mustPick ? 0 : -1e5;
        if (dp[mustPick][i] != -1)
            return dp[mustPick][i];
        if (mustPick)
            return dp[mustPick][i] = max(0, A[i] + solve(A, i + 1, true, dp));
        return dp[mustPick][i] = max(solve(A, i + 1, false, dp), A[i] + solve(A, i + 1, true, dp));
    }
};

// Tabulation
// 위 재귀 함수를 반복문으로 구현 (dp array를 사용한 bottom-up 방식)
class Solution4
{
public:
    int maxSubArray(vector<int> &nums)
    {
        vector<vector<int>> dp(2, vector<int>(size(nums)));
        dp[0][0] = dp[1][0] = nums[0];
        for (int i = 1; i < size(nums); i++)
        {
            dp[1][i] = max(nums[i], nums[i] + dp[1][i - 1]);
            dp[0][i] = max(dp[0][i - 1], dp[1][i]);
        }
        return dp[0].back();
    }
};

class Solution5
{
public:
    int maxSubArray(vector<int> &nums)
    {
        vector<int> dp(nums);
        for (int i = 1; i < size(nums); i++)
            dp[i] = max(nums[i], nums[i] + dp[i - 1]);
        return *max_element(begin(dp), end(dp));
    }
};

// Kadane's Algorithm
class Solution6
{
public:
    int maxSubArray(vector<int> &nums)
    {
        int curMax = 0, maxTillNow = INT_MIN;
        for (auto c : nums)
            curMax = max(c, curMax + c),
            maxTillNow = max(maxTillNow, curMax);
        return maxTillNow;
    }
};

// Divide and Conquer
class Solution7
{
public:
    int maxSubArray(vector<int> &nums)
    {
        return maxSubArray(nums, 0, size(nums) - 1);
    }
    int maxSubArray(vector<int> &A, int L, int R)
    {
        if (L > R)
            return INT_MIN;
        int mid = (L + R) / 2, leftSum = 0, rightSum = 0;
        // leftSum = max subarray sum in [L, mid-1] and starting from mid-1
        for (int i = mid - 1, curSum = 0; i >= L; i--)
            curSum += A[i],
                leftSum = max(leftSum, curSum);
        // rightSum = max subarray sum in [mid+1, R] and starting from mid+1
        for (int i = mid + 1, curSum = 0; i <= R; i++)
            curSum += A[i],
                rightSum = max(rightSum, curSum);
        // return max of 3 cases
        return max({maxSubArray(A, L, mid - 1), maxSubArray(A, mid + 1, R), leftSum + A[mid] + rightSum});
    }
};

// https://leetcode.com/problems/maximum-subarray/solutions/5378437/video-simple-solution/
class Solution8
{
public:
    int maxSubArray(vector<int> &nums)
    {
        int res = nums[0];
        int total = 0;

        for (int n : nums)
        {
            if (total < 0)
            {
                total = 0;
            }

            total += n;
            res = max(res, total);
        }

        return res;
    }
};