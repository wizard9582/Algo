import sys

n = int(sys.stdin.readline())
t, f, m = n // 2, 0, n % 2

while True:
    if m == 1 and t >= 2:
        t -= 2
        f += 1
        m = 0
    elif t >= 5:
        t -= 5
        f += 2
    else:
        break

if m == 0:
    print(t + f)
else:
    print(-1)