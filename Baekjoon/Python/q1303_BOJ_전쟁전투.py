import sys
from collections import deque

nm = sys.stdin.readline().split(' ')
M = int(nm[0])
N = int(nm[1])
B, W = 0, 0
maps = []
delta = [[-1, 0],[1, 0],[0, -1],[0, 1]]

for n in range(N):
    maps.append(list(sys.stdin.readline()))

for n in range(N):
    for m in range(M):
        maps[n][m] = 0 if maps[n][m] == 'W' else 1

for n in range(N):
    for m in range(M):
        if maps[n][m] in [0, 1]:
            target = maps[n][m]
            count = 0
            queue = deque()
            queue.append([n, m])
            maps[n][m] = -1

            while len(queue) > 0:
                x, y = queue.popleft()
                count += 1

                for i in range(4):
                    nx = x + delta[i][0]
                    ny = y + delta[i][1]
                    if 0 <= nx < N and 0 <= ny < M and maps[nx][ny] == target:
                        queue.append([nx,ny])
                        maps[nx][ny] = -1

            count *= count
            if target == 0:
                W += count
            else:
                B += count

print(f"{W} {B}")


