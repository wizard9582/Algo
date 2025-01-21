import sys


s = sys.stdin.readline().strip()
arr = [[0] * 3 for i in range(3)]
i = 0
cs = {"C": 0, "H": 1, "O":2}

for j in range(len(s)):
    c = s[j]
    if c == "+" or c == "=":
        i += 1
        continue

    if 48 <= ord(c) <= 57:
        arr[i][cs[s[j - 1]]] += int(c) - 1
    else:
        arr[i][cs[c]] += 1

f = True

for i in range(1, 11):
    for j in range(1, 11):
        for k in range(1, 11):

            if f and arr[0][0] * i + arr[1][0] * j == arr[2][0] * k and arr[0][1] * i + arr[1][1] * j == arr[2][1] * k and arr[0][2] * i + arr[1][2] * j == arr[2][2] * k:
                f = False
                print(f"{i} {j} {k}")