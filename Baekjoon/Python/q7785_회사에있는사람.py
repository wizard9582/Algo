import sys

n = int(sys.stdin.readline())
com = {}

for i in range(n):
    s = sys.stdin.readline().split()
    if s[0] not in com:
        com[s[0]] = 1
    else:
        com[s[0]] += 1

answer = ""
comp = list(com)
comp.sort(reverse=True)
for c in comp:
    if com[c] % 2 == 1:
        answer += c + "\n"
print(answer)
