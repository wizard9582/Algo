def solution(n):
    c = str(bin(n)[2:]).count('1')
    
    while True:
        n += 1
        if str(bin(n)[2:]).count('1') == c:
            return n