n = int(input())

dp = [0,1,3]

for i in range(2,n):
    dp.append(((dp[i-1]*2)+dp[i])%10007)

print(dp[n])
