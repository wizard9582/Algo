def solution(dartResult):
    answer = [0, 0, 0]

    idx = -1
    i = 0

    while i < len(dartResult):
        if dartResult[i] in ["S", "D", "T"]:
            if dartResult[i] == "D":
                answer[idx] *= answer[idx]
            elif dartResult[i] == "T":
                answer[idx] = answer[idx] * answer[idx] * answer[idx]
        elif dartResult[i] == "*":
            answer[idx] *= 2
            if idx - 1 >= 0:
                answer[idx - 1] *= 2
        elif dartResult[i] == "#":
            answer[idx] *= -1
        else:
            idx += 1
            if dartResult[i] == "1" and i < len(dartResult) - 1 and dartResult[i + 1] == "0":
                answer[idx] = 10
                i += 1
            else :
                answer[idx] = int(dartResult[i])

        i += 1

    return sum(answer)
