import sys
sys.setrecursionlimit(123456)


def dfs(now, before):
    s = 0

    for to in tree[now]:
        if to != before:
            s += dfs(to, now)

    node[now] = s + 1
    return node[now]


N, R, Q = map(int, sys.stdin.readline().split())
tree = [[] for i in range(N + 1)]
node = [0] * (N + 1)

for i in range(N - 1):
    f, t = map(int, sys.stdin.readline().split())
    tree[f].append(t)
    tree[t].append(f)

dfs(R, -1)

answer = ""
for i in range(Q):
    answer += str(node[int(sys.stdin.readline())]) + "\n"

print(answer)