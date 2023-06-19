def solution(n):
    a = 0
    
    while n > 0:
        if n % 2 == 0:
            n //= 2
        else:
            n -= 1
            a += 1
    return a