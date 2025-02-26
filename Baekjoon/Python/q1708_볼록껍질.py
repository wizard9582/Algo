import sys


def ccw(a, b, c):
    return (b[0] - a[0]) * (c[1] - a[1]) - (c[0] - a[0]) * (b[1] - a[1])


N = int(sys.stdin.readline())
points = []

for i in range(N):
    x, y = map(int, sys.stdin.readline().split())
    points.append((x, y))

points.sort(key=lambda x: (x[0], x[1]))

upper = []
for p in points:
    while len(upper) >= 2 and ccw(upper[-2], upper[-1], p) <= 0:
        upper.pop()
    upper.append(p)

points.sort(key=lambda x: (-x[0], x[1]))

lower = []
for p in points:
    while len(lower) >= 2 and ccw(lower[-2], lower[-1], p) <= 0:
        lower.pop()
    lower.append(p)

print(len(set(upper + lower)))