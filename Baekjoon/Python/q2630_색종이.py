import sys

N = int(sys.stdin.readline())
color = []
answer = [0, 0]
# white = 0, blue = 1

for i in range(N):
    color.append(list(map(int, sys.stdin.readline().split(' '))))

def dnc(x, y, s):
    if s == 1:
        answer[color[x][y]] += 1
        return

    c, flag = color[x][y], True
    for i in range(s):
        for j in range(s):
            if color[x + i][y + j] != c:
                flag = False
                break
        if not flag:
            break
    
    if flag:
        answer[c] += 1
    else:
        s //= 2
        dnc(x, y, s)
        dnc(x + s, y, s)
        dnc(x, y + s, s)
        dnc(x + s, y + s, s)
        

dnc(0, 0, N)
print(f"{answer[0]}\n{answer[1]}")

