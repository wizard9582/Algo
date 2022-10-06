def solution(price, money, count):
    gap = money - ((count * (count + 1)) // 2) * price

    return -gap if gap < 0 else 0 