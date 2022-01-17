import sys

N = int(sys.stdin.readline())
idx = 3
dp = [1] * 10001

for i in range(2,10001):
    dp[i] += dp[i-2]

for i in range(3,10001):
    dp[i] += dp[i-3]

sb = ""

for n in range(N):
    target = int(sys.stdin.readline())
    sb += str(dp[target]) + "\n"
    
print(sb)
