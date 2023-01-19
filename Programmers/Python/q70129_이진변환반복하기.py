def solution(s):
    c, z = 0, 0

    while True:
        n = len(s)
        m = s.count('0')

        z += m
        c += 1

        n -= m
        if n == 1:
            break
        s = bin(n)[2:]

    return [c, z]