def solution(ingredient):
    answer = 0
    remain = []

    for i in ingredient:
        if i == 1 and len(remain) >= 3 and remain[-1] == 3 and remain[-2] == 2 and remain[-3] == 1:
            for _ in range(3):
                remain.pop()
            answer += 1
        else:
            remain.append(i)

    return answer
