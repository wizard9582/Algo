import sys
from collections import deque


def solution():
    n, m = map(int, sys.stdin.readline().split())
    con = [[] for i in range(n + 1)]

    for i in range(m):
        f, t = map(int, sys.stdin.readline().split())
        con[f].append(t)
        con[t].append(f)

    visited = [0] * (n + 1)
    q = deque()

    for i in range(1, n + 1):
        if visited[i] == 0:
            visited[i] = 1
            q.append(i)

        while q:
            s = len(q)
            for j in range(s):
                now = q.popleft()

                for to in con[now]:
                    if visited[to] == 0:
                        visited[to] = -visited[now]
                        q.append(to)
                    if visited[to] == visited[now]:
                        return False
    return True


T = int(sys.stdin.readline())

for _ in range(T):
    res = solution()
    print("possible" if res else "impossible")
