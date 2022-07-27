
class Solution:
    def jump(self, nums: list) -> int:
        step = 0
        position = 0
        canMove = 0
        
        while(position < len(nums)-1):
            step += 1
            maxMove = 0
            
            while(position <= canMove):
                maxMove = max(maxMove, position+nums[position])
                position += 1
                if(maxMove >= len(nums)-1):
                    return step
                
            canMove = maxMove
        
        return step

input = [[0],[2,3,1,1,4],[2,3,0,1,4]]

for i in input:
    print(Solution().jump(i))

