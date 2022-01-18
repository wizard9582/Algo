import sys

N = int(sys.stdin.readline())
num = [0] * N
dp = [0] * (N)

for n in range(N):
    num[n] = int(sys.stdin.readline())

dp[0] = 1
for n in range(1,N):
    Max = 1
    for i in range(0,n):
        if(num[i] < num[n]):
            Max = max(dp[i] + 1, Max)
    dp[n] = Max

print(N-max(dp))
