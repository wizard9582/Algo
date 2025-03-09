import sys
from collections import deque


N, L = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().strip().split()))
deq = deque()
answer = []

for i in range(N):

    if deq and deq[0][1] <= i - L:
        deq.popleft()

    while deq and deq[-1][0] > arr[i]:
        deq.pop()

    deq.append([arr[i], i])
    answer.append(deq[0][0])

print(*answer)