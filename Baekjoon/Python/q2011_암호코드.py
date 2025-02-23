import sys


arr = [int(c) for c in sys.stdin.readline().strip()]
n = len(arr)

dp = [0] * n

if arr[0] != 0:
    dp[0] = 1
if n > 1:
    if arr[0] * 10 + arr[1] <= 26:
        dp[1] += dp[0]
    if arr[1] != 0:
        dp[1] += 1

for i in range(2, n):
    if arr[i] != 0:
        dp[i] = dp[i - 1]
    if arr[i - 1] != 0 and arr[i - 1] * 10 + arr[i] <= 26:
        dp[i] += dp[i - 2]
    dp[i] %= 1000000

if arr[0] == 0:
    dp[n - 1] = 0

print(dp[n - 1])
