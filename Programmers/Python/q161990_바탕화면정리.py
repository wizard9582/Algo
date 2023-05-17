def solution(wallpaper):
    lr, lc, rr, rc = 100, 100, -1, -1
    
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[0])):
            if wallpaper[i][j] == '#':
                lr = min(lr, i)
                lc = min(lc, j)
                rr = max(rr, i + 1)
                rc = max(rc, j + 1)
    
    return [lr, lc, rr, rc]