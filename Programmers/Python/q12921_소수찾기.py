def solution(n):
    answer = 0
    divided = [False for i in range(n+1)]

    for i in range(2, n + 1):
        if not divided[i]:
            answer += 1
            d = i * 2
            while d <= n:
                divided[d] = True
                d += i

    return answer