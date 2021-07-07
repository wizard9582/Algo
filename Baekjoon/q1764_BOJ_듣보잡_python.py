import sys

N,M = map(int, sys.stdin.readline().split())
s = set()
l = list()

for i in range(0,N):
    s.add(sys.stdin.readline().strip())

for i in range(0,M):
    now = sys.stdin.readline().strip()
    if(now in s):
        l.append(now)

l.sort()

print(len(l))
for i in l :
    print(i)