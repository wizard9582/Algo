import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
m = arr[0]
answer = 0

for i in range(1, n):
    answer = max(answer, arr[i] - m)
    m = min(m, arr[i])

print(answer)
