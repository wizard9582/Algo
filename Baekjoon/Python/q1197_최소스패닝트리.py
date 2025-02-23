import sys


sys.setrecursionlimit(10**6)
V, E = map(int, sys.stdin.readline().split())

edges = []
parent = [i for i in range(V + 1)]
answer = 0


def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


for i in range(E):
    f, t, cost = map(int, sys.stdin.readline().split())
    edges.append([cost, f, t])

edges.sort()

for cost, f, t in edges:
    if find(f) != find(t):
        union(f, t)
        answer += cost

print(answer)
