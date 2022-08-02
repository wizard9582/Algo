class Solution:
    def getMaxLen(self, nums: list) -> int:
        answer = -1
        zeroInedx = -1
        firstNegative = -1
        negativeCount = 0
        
        for i in range(0, len(nums)):
            if(nums[i] == 0):
                firstNegative = -1
                negativeCount = 0
                zeroInedx = i
            
            if(nums[i] < 0):
                negativeCount += 1 
                if(firstNegative == -1):
                    firstNegative = i
            
            if(negativeCount % 2 == 0):
                answer = max(answer, i - zeroInedx)
            else :
                answer = max(answer, i - firstNegative)
        
        return answer
    

input = [[1,-2,-3,4],[0,1,-2,-3,-4],[-1,-2,-3,0,1]]

for i in input:
    print(Solution().getMaxLen(i))