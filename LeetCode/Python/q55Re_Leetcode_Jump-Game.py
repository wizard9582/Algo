class Solution:
    def canJump(self, nums: list) -> bool:
        idx = len(nums)-2
        reach = len(nums)-1
        
        while(idx >= 0):
            if(nums[idx] + idx >= reach):
                reach = idx
            idx -= 1
            
        return reach == 0
    

input = [[2,3,1,1,4],[3,2,1,0,4],[2,0,0]]

for i in input:
    print(Solution().canJump(i))

