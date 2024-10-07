import re

def solution(s):
    num = {}
    answer = []
    
    for n in re.split('[{,}]', s):
        if n:
            nn = int(n)
            if nn in num:
                num[nn] += 1
            else:
                num[nn] = 1
                
    for k in num:
        answer.append([k, num[k]])
        
    answer.sort(key = lambda x: -x[1])
    return [i[0] for i in answer]