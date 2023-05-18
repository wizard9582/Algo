def solution(n, m, section):
    answer = 0
    e = 0
    for s in section:
        if s > e:
            answer += 1
            e = s + m - 1
    
    return answer