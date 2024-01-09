import sys

n = int(sys.stdin.readline())
answer = ""

for i in range(n):
    m = int(sys.stdin.readline())
    s1 = sys.stdin.readline().strip()
    s2 = sys.stdin.readline().strip()
    w, b = 0, 0
    for j in range(m):
        if s1[j] != s2[j]:
            if s1[j] == 'W':
                w += 1
            else:
                b += 1

    g = min(w, b)
    w -= g
    b -= g
    g += w + b
    answer += str(g) + "\n"

print(answer)