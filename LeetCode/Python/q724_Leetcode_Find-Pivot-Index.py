class Solution:
    # def pivotIndex(self, nums: List[int]) -> int:
    def pivotIndex(self, nums: list) -> int:
        pivot = -1
        idx = 0
        leftSum = 0
        rightSum = self.getRightSum(nums)

        while(idx < len(nums)):
            rightSum -= nums[idx]
            if(idx > 0):
                leftSum += nums[idx-1]
            
            if(leftSum == rightSum):
                pivot = idx
                break
            idx += 1

        return pivot
    
    def getRightSum(self, nums:list):
        rightSum = 0
        for i in nums:
            rightSum += i

        return rightSum


input = [[1,7,3,6,5,6],[1,2,3],[2,1,-1]]
for i in input:
    print(Solution().pivotIndex(i))