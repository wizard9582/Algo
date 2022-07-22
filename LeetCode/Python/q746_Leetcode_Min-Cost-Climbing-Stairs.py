class Solution:
    def minCostClimbingStairs(self, cost: list) -> int:
        size = len(cost) + 1
        dp = [0] * size

        for i in range(2,size):
            dp[i] = min((dp[i-1] + cost[i-1]),(dp[i-2] + cost[i-2]))

        return dp[-1]



input = [[10,15,20],[1,100,1,1,1,100,1,1,100,1]]

for i in input:
    print(Solution().minCostClimbingStairs(i))