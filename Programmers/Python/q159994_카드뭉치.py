def solution(cards1, cards2, goal):
    f, i, j = True, 0, 0
    
    for g in goal:
        if i < len(cards1) and cards1[i] == g:
            i += 1
        elif j < len(cards2) and cards2[j] == g:
            j += 1
        else:
            f = False
            break
    
    return "Yes" if f else "No"