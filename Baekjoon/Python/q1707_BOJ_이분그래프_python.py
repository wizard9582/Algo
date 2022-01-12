import sys
from collections import deque

T = int(sys.stdin.readline().strip())

def bfs():
    V,E = map(int, sys.stdin.readline().split(' '))
    visited = list(0 for v in range(0,V+1))
    vlist = list(list() for v in range(0,V+1))

    for e in range(0,E):
        left, right = map(int, sys.stdin.readline().split(' '))
        vlist[left].append(right)
        vlist[right].append(left)

    for v in range(1,V+1):
        if(visited[v] == 0):
            visited[v] = 1
            queue = deque([v])
        
            while queue:
                now = queue.popleft()
                team = visited[now]
                nexts = vlist[now]

                for next in nexts:
                    if(visited[next] == 0):
                        queue.append(next)
                        visited[next] = (team%2) + 1
                    if(visited[next] == team):
                        print('NO')
                        return

    print('YES')
    return

for t in range(0,T):
    bfs()