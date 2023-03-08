import sys

N = int(sys.stdin.readline())
boxs = list(map(int, sys.stdin.readline().split(' ')))
dp = [1] * N

answer = 0

for n in range(0,N):
    Max = 1
    for m in range(0,n):
        if(boxs[m] < boxs[n]):
            Max = max(Max, dp[m]+1)
    dp[n] = Max

for n in range(0,N):
    answer = max(answer, dp[n])

print(answer)