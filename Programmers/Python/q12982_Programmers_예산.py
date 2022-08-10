def solution(d, budget):
    answer = 0
    d.sort()
    
    for req in d:
        if budget - req >= 0:
            answer += 1
            budget -= req
        else:
            break
    
    return answer