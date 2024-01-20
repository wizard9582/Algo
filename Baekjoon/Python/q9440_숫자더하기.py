import sys

answer = ""
zero = 0
while True:
    arr = list(map(int, sys.stdin.readline().split()))
    if len(arr) == 1:
        break
    arr = arr[1:]
    arr.sort()
    n = len(arr)
    i = 0
    while arr[i] == 0:
        i += 1
    a, b = str(arr[i]), str(arr[i + 1])
    zero = i
    i += 2

    for j in range(zero):
        if j % 2 == 0:
            a += "0"
        else:
            b += "0"

    for j in range(i, n):
        if j % 2 == 0:
            a += str(arr[j])
        else:
            b += str(arr[j])
    answer += str(int(a) + int(b)) + "\n"

print(answer)