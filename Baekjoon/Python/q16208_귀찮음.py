import sys


N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().strip().split()))
arr.sort()
answer = 0
l = sum(arr)

for i in range(N - 1):
    l -= arr[i]
    answer += l * arr[i]

print(answer)