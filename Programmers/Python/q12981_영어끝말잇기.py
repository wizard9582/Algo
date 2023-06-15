def solution(n, words):
    answer = [0, 0]
    b = words[0][-1]
    idx = 1
    who = 1
    duple = {}
    duple[words[0]] = 1
    
    while idx < len(words):
        if words[idx] in duple or words[idx][0] != b:
            answer = [who + 1, (idx // n) + 1]
            break
        else:
            b = words[idx][-1]
            duple[words[idx]] = 1
            who = (who + 1) % n
            idx += 1
    
    return answer