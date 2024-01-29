import sys

n = int(sys.stdin.readline())

day = []
sys.stdin.readline()
for i in range(n - 1):
    t = int(sys.stdin.readline()) - 1
    f = True

    for d in day:
        if t % d == 0:
            f = False
            break

    if f:
        day.append(t)

print(len(day))