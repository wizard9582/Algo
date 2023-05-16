def solution(name, yearning, photo):
    answer = []
    m = {}
    for i in range(len(name)):
        m[name[i]] = yearning[i]
    
    for pho in photo:
        s = 0
        for p in pho:
            if p in m:
                s += m[p]
        answer.append(s)
    return answer