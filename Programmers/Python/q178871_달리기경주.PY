def solution(players, callings):
    n = len(players)
    
    ranking = []
    idxset = {}
    for i in range(n):
        ranking.append(players[i])
        idxset[players[i]] = i
    
    for c in callings:
        t = idxset[c]
        f = ranking[t - 1]
        
        ranking[t - 1] = c
        ranking[t] = f
        
        idxset[c] = t - 1
        idxset[f] = t
        
    return ranking