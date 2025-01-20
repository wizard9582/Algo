import sys


N, M = map(int, sys.stdin.readline().split())

arr = [[0] * M for i in range(N)]

for i in range(2 * N):
    add = list(map(int, sys.stdin.readline().split()))
    t = i % N
    for j in range(M):
        arr[t][j] += add[j]

answer = ""

for i in range(N):
    answer += ' '.join([str(j) for j in arr[i]]) + "\n"

print(answer)