def solution(n, m):
    md = gcd(n, m)

    answer = [md, n * m / md]
    return answer


def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)
