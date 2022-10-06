def solution(s):
    c = len(s) // 2

    if len(s) % 2 == 0:
        return s[c - 1: c + 1]
    else:
        return s[c]