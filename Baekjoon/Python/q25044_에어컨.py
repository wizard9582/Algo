import sys

n, k = sys.stdin.readline().split()
n, k = int(n), int(k)

t = [180, 180, 1080 + k]

d = 1440 * n
g = 900
i = 0
while g <= d:
    g += t[i]
    i = (i + 1) % 3

print(g)