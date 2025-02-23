import sys


arr = [int(c) for c in sys.stdin.readline().strip()]
n = len(arr)

dp = [0] * n

if arr[0] != 0:
    dp[0] = 1

for i in range(1, n):
    if arr[i] != 0:
        dp[i] += dp[i - 1]
    if 10 <= arr[i - 1] * 10 + arr[i] <= 26:
        dp[i] += dp[i - 2] if i > 1 else 1
    dp[i] %= 1000000

print(dp[-1])
