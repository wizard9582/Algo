import sys

n = int(sys.stdin.readline())
answer = ""

for i in range(n):
    s1, s2 = [0] * 26, [0] * 26
    for c in sys.stdin.readline():
        s1[ord(c) - 97] += 1
    for c in sys.stdin.readline():
        s2[ord(c) - 97] += 1
    dis = 0

    for j in range(26):
        if s1[j] != s2[j]:
            dis += abs(s1[j] - s2[j])
    
    answer += f"Case #{i + 1}: {dis}\n"

print(answer)