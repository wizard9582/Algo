import sys
import math

n = int(sys.stdin.readline())

if n == 0:
    print(0)
else:
    arr = []

    for i in range(n):
        arr.append(int(sys.stdin.readline()))

    arr.sort()
    s = len(arr)
    g = math.floor(s * 0.15 + 0.5)
    # print(sum(arr[g:s - g]) / (s - 2 * g))
    print(math.floor(sum(arr[g:s - g]) / (s - 2 * g) + 0.5))