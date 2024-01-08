import sys

a, b, c = map(int, sys.stdin.readline().split())

if a == b and b == c:
    print(10000 + a * 1000)
else:
    arr = [a, b, c]
    arr.sort()
    if a == b or b == c or a == c:
        print(1000 + arr[1] * 100)
    else:
        print(arr[2] * 100)