def solution(brown, yellow):
    for i in range(2, brown):
        for j in range(2, brown):
            if j > i:
                break
            if brown == 2 * i + 2 * j - 4 and yellow == (i - 2) * (j - 2):
                return [i, j]
            