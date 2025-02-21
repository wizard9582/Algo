import sys
import heapq

N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().strip().split()))

if max(arr) > 1440:
    print(-1)

else:
    arr = [-a for a in arr]
    arr.append(0)
    heapq.heapify(arr)
    t = 0

    while sum(arr) < 0:
        t += 1
        if t > 1440:
            t = -1
            break

        h1, h2 = heapq.heappop(arr), heapq.heappop(arr)

        if h2 < 0:
            heapq.heappush(arr, h1 + 1)
            heapq.heappush(arr, h2 + 1)
        else:
            t += (-h1) - 1

    print(t if t <= 1440 else -1)