def solution(s):
    count = 0
    for b in s:
        if b == '(':
            count += 1
        else:
            count -= 1
        if count < 0:
            return False

    return True if count == 0 else False
