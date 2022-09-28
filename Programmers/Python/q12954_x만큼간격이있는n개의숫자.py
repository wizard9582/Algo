def solution(x, n):
    answer = []
    d = x
    for i in range(n):
        answer.append(x)
        x += d
    return answer