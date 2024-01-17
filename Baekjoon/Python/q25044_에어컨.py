import sys

n, k = sys.stdin.readline().split()
n, k = int(n), int(k)

t = 900
gap = [180, 180, k + 1080]
answer = []

d, e = 1440 * n, 1440 * (n + 1)
idx = 0

while t < e:
    if d <= t < e:
        answer.append(t - d)
    t += gap[idx]
    idx = (idx + 1) % 3

print(len(answer))
for a in answer:
    m = a // 60
    d = a % 60
    m = str(m) if m >= 10 else "0" + str(m)
    d = str(d) if d >= 10 else "0" + str(d)
    print(m + ":" + d)
