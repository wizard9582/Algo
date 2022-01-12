import sys
from collections import deque

N,M = map(int, sys.stdin.readline().split(' '))

def isIn(x,y):
    if(0 <= x and x < N and 0 <= y and y < M):
        return True
    return False

delta = [[-1,0],[1,0],[0,-1],[0,1]]
visited = [[False for m in range(M)] for n in range(N)]
map = list()
queue = deque()
answer = 0

for n in range(N):
    input = sys.stdin.readline()
    row = list()
    for m in range(len(input)):
        if(input[m] == 'I'):
            row.append('O')
            queue.append([n,m])
            visited[n][m] = True
        else:
            row.append(input[m])
    map.append(row)

while queue:
    now = queue.popleft()
    x = now[0]
    y = now[1]

    for i in range(4):
        nX = x + delta[i][0]
        nY = y + delta[i][1]

        if(isIn(nX,nY) and not visited[nX][nY]):
            visited[nX][nY] = True
            if(map[nX][nY] == 'O'):
                queue.append([nX,nY])
            elif(map[nX][nY] == 'P'):
                answer += 1
                queue.append([nX,nY])

if(answer == 0):
    print('TT')
else:
    print(answer)
