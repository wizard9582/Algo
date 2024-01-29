import sys

r, c = map(int, sys.stdin.readline().split())
cw = []
for i in range(r):
    cw.append(sys.stdin.readline().strip())
cand = []

for i in range(r):
    w = ""
    for j in range(c):
        if cw[i][j] == "#":
            if len(w) >= 2:
                cand.append(w)
            w = ""
        else:
            w += cw[i][j]
    if len(w) >= 2:
        cand.append(w)

for i in range(c):
    w = ""
    for j in range(r):
        if cw[j][i] == "#":
            if len(w) >= 2:
                cand.append(w)
            w = ""
        else:
            w += cw[j][i]
    if len(w) >= 2:
        cand.append(w)

cand.sort()
print(cand[0])