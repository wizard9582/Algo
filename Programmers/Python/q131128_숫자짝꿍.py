def solution(X, Y):

    numx = [0 for i in range(10)]
    numy = [0 for i in range(10)]
    answer = []

    for n in X:
        numx[int(n)] += 1
    for n in Y:
        numy[int(n)] += 1

    pred = min(numx[0], numy[0])
    for i in range(10):
        n = min(numx[i], numy[i])
        for j in range(n):
            answer.append(str(i))

    answer.sort(reverse=True)

    if len(answer) == 0:
        return "-1"

    return ''.join(answer) if len(answer) > pred else "0"
