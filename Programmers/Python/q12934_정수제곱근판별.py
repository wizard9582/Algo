import math


def solution(n):
    x = math.sqrt(n)
    xd = x // 1

    if x == xd:
        return (x + 1) * (x + 1)
    else:
        return -1
