import sys
from collections import deque

n = int(sys.stdin.readline())
arr = [i + 1 for i in range(n)]
q = deque(arr)
answer = ""

while len(q) > 1:
    answer += str(q.popleft()) + " "
    q.append(q.popleft())

if len(q) > 0:
    answer += str(q.popleft())

print(answer)
