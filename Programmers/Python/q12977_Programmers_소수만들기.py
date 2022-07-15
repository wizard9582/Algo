import copy

def solution(nums):

    def sumCombination(combination):
        return combination[0] + combination[1] + combination[2]

    def makeCombination(list, idx, count):
        if(count == 3):
            combinationList.append(copy.deepcopy(list))
            return
        
        for i in range(idx,len(nums)):
            list[count] = nums[i]
            makeCombination(list, i+1, count+1)


    def makePrimeNumber():
        number = [0 for i in range(50_001)]
        number[1] = 1
        for i in range(2,50_001):
            if(number[i] == 0):
                j = i * 2
                while(j < 50_001):
                    number[j] = 1
                    j += i
        return number

    combinationList = []
    primeNumber = makePrimeNumber()
    makeCombination([0]*3, 0, 0)
    answer = 0
    for i in combinationList:
        sum = sumCombination(i)
        if(primeNumber[sum] == 0):
            answer += 1
            
    return answer


nums = [1,2,7,6,4]
print(solution(nums))