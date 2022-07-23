class Solution:
    def deleteAndEarn(self, nums: list) -> int:
        expectValue = [0] * 10001
        for i in nums:
            expectValue[i] += i
        
        dp = [0] * 10001
        dp[1] = expectValue[1]
        for i in range(2,10001):
            dp[i] = max(dp[i-1], dp[i-2]+expectValue[i])
        
        return dp[-1]
    

input = [[3,4,2], [2,2,3,3,3,4]]
for i in input:
    print(Solution().deleteAndEarn(i))