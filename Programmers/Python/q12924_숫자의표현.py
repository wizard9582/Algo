def solution(n):
    answer = 0
    
    for i in range(1, n + 1):
        c, j = i, 0
        while c <= n:
            if c == n:
                answer += 1
                break
            
            j += 1
            c += i + j
    
    return answer