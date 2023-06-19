import math

def solution(n,a,b):
    answer = math.log2(n)
    a, b = a - 1, b - 1
    
    while n > 1:
        n //= 2
        if a // n == b // n:
            answer -= 1
        else:
            break

    return answer