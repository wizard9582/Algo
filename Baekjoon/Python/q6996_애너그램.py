import sys

n = int(sys.stdin.readline())

for i in range(n):
    w = sys.stdin.readline().split()
    a, b = [0] * 26, [0] * 26
    for c in w[0]:
        a[ord(c) - 97] += 1
    for c in w[1]:
        b[ord(c) - 97] += 1
    
    f = True
    for j in range(26):
        if a[j] != b[j]:
            f = False
            break
    g = "anagrams." if f else "NOT anagrams."
    print(f"{w[0]} & {w[1]} are " + g)

