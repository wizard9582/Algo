import sys

n = int(sys.stdin.readline())
board = []
delta = [[1, 0], [0, 1], [1, 1], [-1, 1]]

for i in range(n):
    board.append(sys.stdin.readline().strip())

f = True
i = 0

while f and i < n:
    j = 0
    while f and j < n:
        if board[i][j] != '.':
            for d in range(4):
                c = 1
                x, y = i, j
                for k in range(2):
                    x, y = x + delta[d][0], y + delta[d][1]
                    if 0 <= x < n and 0 <= y < n and board[x][y] == board[i][j]:
                        c += 1
                if c == 3:
                    f = False
                    print(board[i][j])
                    break
        j += 1
    i += 1
if f:
    print("ongoing")