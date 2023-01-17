def solution(k, score):
    glory = [-1 for i in range(k)]
    answer = []
    
    for s in score:
        if s > glory[0]:
            glory[0] = s
            glory.sort()
        
        for g in glory:
            if g != -1:
                answer.append(g)
                break
    
    return answer