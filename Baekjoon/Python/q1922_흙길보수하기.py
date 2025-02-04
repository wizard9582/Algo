import sys

N, L = map(int, sys.stdin.readline().split())

pool = []
answer = 0

for _ in range(N):
    s, e = map(int, sys.stdin.readline().split())
    pool.append([s, e])

pool.sort(key = lambda x : x[0])

last = 0

for s, e in pool:
    s = max(last, s)

    w = e - s
    c = w // L
    if w % L != 0:
        c += 1

    answer += c
    last = s + c * L

print(answer)