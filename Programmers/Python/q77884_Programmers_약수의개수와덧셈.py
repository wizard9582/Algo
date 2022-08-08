def solution(left, right):
    answer = 0
    
    for num in range(left, right+1):
        count = 2 if num != 1 else 1
        for div in range(2, (num//2) + 1):
            if num % div == 0:
                count += 1 
        if count % 2 == 0:
            answer += num
        else:
            answer -= num
    
    return answer