def solution(bandage, health, attacks):
    h, idx, b, e = health, 0, 0, attacks[-1][0]
    
    for i in range(e + 1):
        if i == attacks[idx][0]:
            h -= attacks[idx][1]
            b = 0
            idx += 1
        else:
            b += 1
        
            if b == bandage[0]:
                b = 0
                h = min(health, h + bandage[1] + bandage[2])
            else:
                h = min(health, h + bandage[1])
        
        if h <= 0:
            break
    
    return -1 if h <= 0 else h


def solution(bandage, health, attacks):
    h, idx, b, e = health, 0, 0, attacks[-1][0]
    
    for i in range(e + 1):
        if i == attacks[idx][0]:
            h -= attacks[idx][1]
            b = 0
            idx += 1
        else:
            b += 1
            h = min(health, h + bandage[1])
        
            if b == bandage[0]:
                b = 0
                h = min(health, h + bandage[2])
        
        if h <= 0:
            return -1
    
    return h