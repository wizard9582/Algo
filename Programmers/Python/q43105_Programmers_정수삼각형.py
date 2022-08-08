def solution(triangle):
    answer = 0
    height = len(triangle)
    dp = [[0 for i in range(height)] for j in range(height)]

    dp[0][0] = triangle[0][0]

    for i in range(1, height):
        dp[i][0] = dp[i - 1][0] + triangle[i][0]
        for j in range(1, i):
            dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j]
        dp[i][i] = dp[i - 1][i - 1] + triangle[i][i]

    for i in range(height):
        answer = max(answer, dp[height - 1][i])
    
    return answer