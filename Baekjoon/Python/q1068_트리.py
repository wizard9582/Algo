import sys
from collections import deque

answer = 0
n = int(sys.stdin.readline())
edge = list(map(int, sys.stdin.readline().split()))
d = int(sys.stdin.readline())
root = 0

tree = [[] for i in range(n)]
for i in range(n):
    if edge[i] == -1:
        root = i
    elif i != d:
        tree[edge[i]].append(i)

if d == root:
    print(0)
else:
    q = deque()
    q.append(root)

    while q:
        now = q.popleft()
        if len(tree[now]) == 0:
            answer += 1
        else:
            for t in tree[now]:
                q.append(t)

    print(answer)