import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
answer, idx, c = 0, 1, 1

while idx < n:
    if arr[idx - 1] < arr[idx]:
        c += 1
    else:
        answer += c * (c + 1) // 2
        c = 1

    idx += 1

answer += c * (c + 1) // 2

print(answer)