def solution(k, m, score):
    score.sort(key = lambda x : -x)
    
    answer, i = 0, m - 1
    
    while i < len(score):
        answer += score[i] * m
        i += m
    
    return answer