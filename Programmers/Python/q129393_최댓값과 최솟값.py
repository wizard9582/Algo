def solution(s):
    minn = float("inf")
    maxn = -float("inf")
    number = list(s.split(' '))

    for num in number:
        n = int(num)

        minn = min(n, minn)
        maxn = max(n, maxn)

    return f"{minn} {maxn}"