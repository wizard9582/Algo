class Solution:
    def maxSubArray(self, nums: list) -> int:
        sum = -100_000
        maxSum = -100_000
        for i in nums:
            if(i > i + sum):
                sum = i
            else:
                sum += i
                
            maxSum = max(sum, maxSum)
                
        return maxSum

input = [[-2,1,-3,4,-1,2,1,-5,4],[1],[5,4,-1,7,8]]
for i in input:
    print(Solution().maxSubArray(i))