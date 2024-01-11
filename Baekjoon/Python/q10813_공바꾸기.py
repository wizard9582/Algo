import sys

n, m = map(int, sys.stdin.readline().split())
arr = [i + 1 for i in range(n)]

for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    t = arr[a - 1]
    arr[a - 1] = arr[b - 1]
    arr[b - 1] = t

answer = ""
for i in range(n):
    answer += str(arr[i]) + " "
print(answer)