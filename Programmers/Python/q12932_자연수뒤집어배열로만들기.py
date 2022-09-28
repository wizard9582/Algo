def solution(n):
    answer = list(str(n))
    answer.reverse()

    for i in range(len(answer)):
        answer[i] = int(answer[i])

    return answer