class Solution:
    def rob(self, nums: list) -> int:
        if(len(nums) == 1):
            return nums[0]
        
        dp = [0] * (len(nums) + 1)
        dp[0] = 0
        dp[1] = nums[0]
        dp[2] = nums[1]

        for i in range(3, len(nums)+1):
            dp[i] = max(dp[i-2],dp[i-3]) + nums[i-1]

        return max(dp[-1],dp[-2])


input = [[1,2,3,1],[2,7,9,3,1]]
for i in input:
    print(Solution().rob(i))