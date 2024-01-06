import sys

n = int(sys.stdin.readline())
s1 = sys.stdin.readline()
m = int(sys.stdin.readline())
s2 = sys.stdin.readline()
answer, idx, i = 0, n - 1, m

def check(s1, s2):
    for c in s2:
        if c not in s1:
            return False
    return True

if check(s1, s2):
    while i > 0:
        idx = (idx + 1) % n
        if s1[idx] == s2[m - i]:
            i -= 1
        answer += 1

    print(answer)
else:
    print(-1)