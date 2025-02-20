import sys

n, w, L = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
ontime = [0] * n

s, l, r, t = 0, 0, 0, 0

while r < n:
    if ontime[l] + w <= t:
        s -= arr[l]
        l += 1

    if r - l + 1 <= w and s + arr[r] <= L:
        s += arr[r]
        ontime[r] = t
        r += 1

    t += 1

print(ontime[-1] + w + 1)