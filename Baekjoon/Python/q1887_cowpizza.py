import sys
from itertools import combinations


T, N = map(int, sys.stdin.readline().split())
arr = [i for i in range(T)]
exc = []

for i in range(N):
    rm = list(map(int, sys.stdin.readline().split()))
    if rm[0] == 1:
        arr.remove(rm[1] - 1)
    else:
        exc.append(sum([1 << (rm[j] - 1) for j in range(1, len(rm))]))

answer = 0
for i in range(len(arr) + 1):
    for comb in combinations(arr, i):
        s = sum([1 << c for c in comb])
        f = True

        for ex in exc:
            if s & ex == ex:
                f = False
                break

        answer += f

print(answer)