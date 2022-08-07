def solution(nums):
    answer = 0
    count = len(nums) // 2
    picked = [False for i in range(200_001)]
    
    index = 0
    while answer < count and index < len(nums):
        if not picked[nums[index]]:
            picked[nums[index]] = True
            answer += 1
            
        index += 1
    
    return answer

def solution_with_dict(nums):
    answer = 0
    count = len(nums) // 2
    picked = {}
    
    index = 0
    while answer < count and index < len(nums):
        if not nums[index] in picked:
            picked[nums[index]] = 1
            answer += 1
        index += 1
    
    return answer