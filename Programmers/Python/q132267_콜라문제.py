def solution(a, b, n):
    answer = 0

    while n >= a:
        bottle = (n // a) * b
        n = (n % a) + bottle
        answer += bottle

    return answer


print(solution(2, 1, 20))