class Solution:
    def jump(self, nums: list) -> int:
        dp = [20000]*len(nums)
        dp[0] = 0
        
        for i in range(0, len(nums)-1):
            for j in range(i+1, min(len(nums), i + nums[i] + 1)):
                dp[j] = min(dp[i]+1, dp[j])
        return dp[-1]
    

input = [[2,3,1,1,4],[2,3,0,1,4]]

for i in input:
    print(Solution().jump(i))

