def solution(food):
    s = ''
    
    for i in range(1, len(food)):
        c = food[i] // 2
        s += str(i) * c
    
    r = s[::-1]
    
    return s + '0' + r