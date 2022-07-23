class Solution:
    def rob(self, nums: list) -> int:
        
        dp = [0] * (len(nums) + 1)
        dp[0] = 0
        dp[1] = nums[0]

        for i in range(2, len(nums)+1):
            dp[i] = max(dp[i-1],dp[i-2]+ nums[i-1])

        return dp[-1]


input = [[1,2,3,1],[2,7,9,3,1],[1]]
for i in input:
    print(Solution().rob(i))