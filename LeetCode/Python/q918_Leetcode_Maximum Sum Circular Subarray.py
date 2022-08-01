class Solution:
    def maxSubarraySumCircular(self, nums: list) -> int:
        nonCircularSum = self.maxSubArray(nums)
        circularSum = sum(nums)
        
        for i in range(0,len(nums)):
            nums[i] = -nums[i]
        
        circularSum += self.maxSubArray(nums)
        
        return max(nonCircularSum,circularSum) if(circularSum != 0) else nonCircularSum
    
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

input = [[1,-2,3,-2],[5,-3,5],[-3,-2,-3]]
for i in input:
    print(Solution().maxSubarraySumCircular(i))