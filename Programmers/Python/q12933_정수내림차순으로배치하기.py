def solution(n):
    num = [0 for i in range(10)]

    for i in str(n):
        num[int(i)] += 1

    answer = ""
    for i in range(10):
        for j in range(num[9-i]):
            answer += str(9-i)

    return int(answer)
