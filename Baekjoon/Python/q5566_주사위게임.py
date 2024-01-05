import sys

n, m = map(int, sys.stdin.readline().split())
board = []

for _ in range(n):
    board.append(int(sys.stdin.readline()))

idx = 0

for i in range(m):
    d = int(sys.stdin.readline())
    idx += d

    if idx < n and board[idx] != 0:
        idx += board[idx]

    if idx >= n:
        print(i + 1)
        break