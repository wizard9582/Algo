import sys

n, m = sys.stdin.readline().split()
n, m = int(n), int(m)

thesis = [False] * (n + 1)
t = list(map(int, sys.stdin.readline().split()))

for c in t:
    thesis[c] = True

s, e, g = 1, 0, 0
answer = 0
while s <= n:
    if thesis[s] == True:
        s += 1
    else:
        answer += 5
        g = 2
        e1, e2 = s - 1, s
        while g > 0 and e1 < n:
            e1 += 1
            if thesis[e1]:
                g -= 1
            else:
                e2 = e1
        
        answer += 2 * (e2 - s)
        s = e2 + 1

print(answer)