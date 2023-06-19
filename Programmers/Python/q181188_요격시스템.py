def solution(targets):
    answer = 1
    targets.sort(key = lambda x : (x[0], x[1]))
    right = targets[0][1]
    
    for idx in range(1, len(targets)):
        if right <= targets[idx][0]:
            right = targets[idx][1]
            answer += 1
            
        else:
            right = min(right, targets[idx][1])
    
    return answer