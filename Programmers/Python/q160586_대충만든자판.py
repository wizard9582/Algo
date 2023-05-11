def solution(keymap, targets):
    answer = []
    keyset = {}
    
    for key in keymap:
        for i in range(len(key)):
            if key[i] not in keyset or keyset[key[i]] > i:
                keyset[key[i]] = i + 1

    for target in targets:
        n, f = 0, True
        for t in target:
            if t not in keyset:
                answer.append(-1)
                f = False
                break
            n += keyset[t]
        if f:
            answer.append(n)
    
    return answer