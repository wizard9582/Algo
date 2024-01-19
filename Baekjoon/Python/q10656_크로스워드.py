import sys

n, m = map(int, sys.stdin.readline().split())
arr = []
for i in range(n):
    arr.append(sys.stdin.readline().strip())
answer = []

for i in range(n):
    for j in range(m):
        if arr[i][j] == "#":
            continue
        c = 0
        if j == 0 or arr[i][j - 1] == "#":
            k = 1
            while k < 3 and j + k < m:
                if arr[i][j + k] == ".":
                    c += 1
                k += 1
        if c == 2:
            answer.append([i + 1, j + 1])

        if c != 2:
            c = 0
            if i == 0 or arr[i - 1][j] == "#":
                k = 1
                while k < 3 and i + k < n:
                    if arr[i + k][j] == ".":
                        c += 1
                    k += 1
            if c == 2:
                answer.append([i + 1, j + 1])

s = str(len(answer)) + "\n"
for a in answer:
    s += f"{a[0]} {a[1]}" + "\n"

print(s)
