import sys


delta = [[-1, 0], [0, 1], [1, 0], [0, -1]]
n = int(sys.stdin.readline())
arr = [['#'] * 110 for i in range(110)]
x, y, d = 55, 55, 2
lt, rb = [55, 55], [55, 55]
arr[x][y] = '.'

s = sys.stdin.readline()
for i in range(n):
    t = s[i]
    if t == "R":
        d = (d + 1) % 4
    elif t == "L":
        d = (d - 1) % 4
    else:
        x, y = x + delta[d][0], y + delta[d][1]
        lt = [min(lt[0], x), min(lt[1], y)]
        rb = [max(rb[0], x), max(rb[1], y)]
        arr[x][y] = '.'

for i in range(lt[0], rb[0] + 1):
    print(''.join(arr[i][lt[1]:rb[1] + 1]))
