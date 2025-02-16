import sys

N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().strip().split()))

answer = [0] * N

for i in range(N):
    c = 0
    for j in range(N):
        if answer[j] == 0:
            if c == arr[i]:
                answer[j] = i + 1
                break
            c += 1

print(' '.join([str(i) for i in answer]))