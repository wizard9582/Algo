import sys

cset = {}
answer = 0

N = int(sys.stdin.readline())
for i in range(N):
    s = sys.stdin.readline()
    n = 1
    for j in range(1, len(s)):
        if s[-j - 1] not in cset:
            cset[s[-j - 1]] = n
        else:
            cset[s[-j - 1]] += n

        n *= 10

arr = []
for c in cset:
    arr.append([c, cset[c]])

arr.sort(key = lambda x: -x[1])

for i in range(len(arr)):
    answer += (9 - i) * arr[i][1]

print(answer)