import sys


N, K = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
answer = 0
b = -1

for i in range(len(arr)):
    if arr[i] > b:
        b = arr[i]
    elif arr[i] + K > b:
        answer += 1
        b = arr[i] + K
    else:
        answer = -1
        break

print(answer)