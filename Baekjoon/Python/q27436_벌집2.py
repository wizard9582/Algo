import sys


N = int(sys.stdin.readline())

if N == 1:
    print(1)

else:
    l, r = 1, N

    while l < r:
        mid = (l + r) // 2

        # print(1 + (3 * (mid + 1) * mid))
        if 1 + (3 * (mid + 1) * mid) >= N:
            r = mid
        else:
            l = mid + 1

    print(l + 1)
