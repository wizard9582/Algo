def solution(arr):
    answer = [0] * 101
    
    for i in range(len(arr)):
        div = [0] * 101
        n = arr[i]
        d = 2
        
        while d <= n:
            if n % d == 0:
                div[d] += 1
                n //= d
            else:
                d += 1
        
        for j in range(1, 101):
            answer[j] = max(answer[j], div[j])
            
    
    ans = 1
    for i in range(1, 101):
        if answer[i] != 0:
            ans *= (i ** answer[i])
            
    return ans
    
                