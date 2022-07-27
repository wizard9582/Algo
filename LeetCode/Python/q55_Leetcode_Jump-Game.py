class Solution:
    def canJump(self, nums: list) -> bool:
        dp = [0]*len(nums)
        dp[0] = 1
        
        for i in range(0, len(nums)-1):
            if(dp[i] == 1):
                idx = i+1
                count = nums[i]
                while(idx < len(nums) and count > 0):
                    dp[idx] = 1
                    count -= 1
                    idx += 1
        return dp[-1] == 1
    

input = [[2,3,1,1,4],[3,2,1,0,4],[2,0,0]]

for i in input:
    print(Solution().canJump(i))

