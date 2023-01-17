def solution(s):
    answer = 0
    mc, yc, m = 0, 0, ' '
    
    for c in s:
        if m == ' ':
            answer += 1
            m = c
        
        if m == c:
            mc += 1
        else:
            yc += 1
        
            if mc == yc:
                mc, yc = 0, 0
                m = ' '
    
    return answer