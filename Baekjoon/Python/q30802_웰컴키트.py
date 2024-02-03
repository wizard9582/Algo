import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
t, p = map(int, sys.stdin.readline().split())

s = 0
for i in arr:
    d = i // t if i % t == 0 else (i // t) + 1
    s += d

print(s)
print(n // p, n % p)