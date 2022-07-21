class Solution:
    # def runningSum(self, nums: List[int]) -> List[int]:
    def runningSum(self, nums: list) -> list:
        sum = 0
        answer = []
        for i in nums:
            sum += i
            answer.append(sum)
        
        return answer


input = [[1,2,3,4],[1,1,1,1,1],[3,1,2,10,1]]
for i in input:
    print(Solution().runningSum(i))