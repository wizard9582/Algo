def solution(N, stages):
    answer = []
    
    fail_rate = [[0, i+1] for i in range(N)]
    stage_user = [0 for i in range(N+1)]
    total_user = len(stages)
    
    for stage in stages:
        stage_user[stage - 1] += 1
    
    for i in range(N):
        if total_user == 0:
            fail_rate[i][0] = 0
        else:
            fail_rate[i][0] = stage_user[i] / total_user
            total_user -= stage_user[i]
    
    fail_rate.sort(key=lambda x:(-x[0], x[1]))
    
    for i in fail_rate:
        answer.append(i[1])
    
    return answer

print(solution(	5, [2, 1, 2, 6, 2, 4, 3, 3]))