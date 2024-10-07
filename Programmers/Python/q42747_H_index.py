def solution(citations):
    citations.sort(key = lambda x: -x)
    
    answer = 0
    n = len(citations)
    
    for i in range(n):
        if citations[i] >= i + 1:
            answer = i + 1
        else:
            break
    
    return answer