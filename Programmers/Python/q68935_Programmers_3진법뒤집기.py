from collections import deque

def solution(n):
    answer = 0
    deq = deque()
    
    while n > 0:
        remain = n % 3
        n = n // 3
        
        deq.append(remain)
    
    while len(deq) > 0:
        answer *= 3
        answer += deq.popleft()
    
    return answer

