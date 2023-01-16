def solution(t, p):
    answer = 0
    
    pn, pl = int(p), len(p)
    
    for i in range(len(t) - pl + 1):
        if int(t[i:i + pl]) <= pn:
            answer += 1
    
    return answer