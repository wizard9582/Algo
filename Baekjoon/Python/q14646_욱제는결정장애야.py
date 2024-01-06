import sys

n = int(sys.stdin.readline())
turn = list(map(int, sys.stdin.readline().split()))
sticker = [True] * (n + 1)
s, m = 0, 0

for t in turn:
    if sticker[t]:
        sticker[t] = False
        s += 1
        m = max(s, m)
    else:
        s -= 1

print(m)