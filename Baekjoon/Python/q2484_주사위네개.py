import sys

n = int(sys.stdin.readline())
answer = -1

for _ in range(n):
    num = sys.stdin.readline().split()
    dice = [0] * 7
    for i in num:
        dice[int(i)] += 1

    if 4 in dice:
        answer = max(answer, 50000 + dice.index(4) * 5000)
    elif 3 in dice:
        answer = max(answer, 10000 + dice.index(3) * 1000)
    elif 2 in dice:
        if 1 in dice:
            answer = max(answer, 1000 + dice.index(2) * 100)
        else:
            d = 2000
            for i in range(6, 0, -1):
                if dice[i] == 2:
                    d += i * 500
            answer = max(answer, d)
    else:
        for i in range(6, 0, -1):
            if dice[i] == 1:
                answer = max(answer, i * 100)
                break

print(answer)