def solution(s):
    p, y  = 0, 0
    s = s.lower()

    for i in s:
        if i == 'p':
            p += 1
        elif i == 'y':
            y += 1
    return p == y