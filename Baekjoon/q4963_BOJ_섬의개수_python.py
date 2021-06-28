from collections import deque
delta = [[-1,0],[1,0],[0,-1],[0,1],[-1,-1],[-1,1],[1,1],[1,-1]]

def isIn(x,y):
    if(0 <= x and x < H and 0 <= y and y < W):
        return True
    return False

def bfs(x,y):
    m[x][y] = 0
    queue = deque([x,y])

    while queue:
        x = queue.popleft()
        y = queue.popleft()
        for i in range(8):
            nX = x + delta[i][0]
            nY = y + delta[i][1]
            if(isIn(nX,nY) and m[nX][nY] == 1):
                m[nX][nY] = 0
                queue.append(nX)
                queue.append(nY)

while True:
    W,H = map(int, input().split(' '))
    if(W == 0 and H == 0):
        break
    
    m = list()
    answer = 0

    for h in range(H):
        m.append(list(map(int, input().split(' '))))
    
    for h in range(H):
        for w in range(W):
            if(m[h][w] == 1):
                answer += 1
                bfs(h,w)
    
    print(answer)