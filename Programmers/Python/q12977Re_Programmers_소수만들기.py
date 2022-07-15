def solution(nums):

    def makePrimeNumber():
        number = [0 for i in range(50_001)]
        number[1] = 1
        for i in range(2, 50_001):
            if(number[i] == 0):
                j = i * 2
                while(j < 50_001):
                    number[j] = 1
                    j += i
        return number

    primeNumber = makePrimeNumber()
    answer = 0

    for i in range(len(nums)):
        for j in range(i+1, len(nums)):
            for k in range(j+1, len(nums)):
                sum = nums[i] + nums[j] + nums[k]
                if(primeNumber[sum] == 0):
                    answer += 1
            
    return answer


nums = [1,2,7,6,4]
print(solution(nums))