def solution(number, limit, power):
    answer = 0
    arr = [1] * (number + 1)
    
    for i in range(2, number + 1):
        d = i
        while d <= number:
            arr[d] += 1
            d += i
    
    for i in range(1, number + 1):
        if arr[i] <= limit:
            answer += arr[i]
        else:
            answer += power
            
    return answer