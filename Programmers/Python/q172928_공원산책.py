def solution(park, routes):
    delta = [[-1, 0], [1, 0], [0, -1], [0, 1]]
    dset = {"N":0, "S":1, "W":2, "E":3}
    r, c, n, m = 0, 0, len(park), len(park[0])
    
    def cango(r, c, d, w):
        nonlocal n, m
        
        for i in range(w):
            r += delta[d][0]
            c += delta[d][1]
            
            if r < 0 or r >= n or c < 0 or c >= m or park[r][c] == 'X':
                return [-1, -1]
            
        return [r, c]
    
    for i in range(n):
        for j in range(m):
            if park[i][j] == 'S':
                r = i
                c = j
    
    for route in routes:
        d, w = route.split(' ')
        d = dset[d]
        w = int(w)
        
        res = cango(r, c, d, w)
        if res[0] != -1:
            r, c = res[0], res[1]
                
    return [r, c]