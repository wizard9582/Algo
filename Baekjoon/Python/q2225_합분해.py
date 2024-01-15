import sys

n, k = map(int, sys.stdin.readline().split())
dp = [[0 for i in range(k + 1)] for j in range(n + 1)]
div = 10 ** 9

for i in range(n + 1):
    dp[i][1] = 1
for i in range(1, k + 1):
    dp[0][i] = 1

for j in range(2, k + 1):
    for i in range(1, n + 1):
        dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % div

print(dp[n][k])