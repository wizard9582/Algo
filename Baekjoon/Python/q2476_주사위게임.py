import sys

n = int(sys.stdin.readline())
answer = -1

for _ in range(n):
    a, b, c = map(int, sys.stdin.readline().split())
    if a == b and b == c:
        answer = max(answer, 10000 + a * 1000)
    else:
        arr = [a, b, c]
        arr.sort()
        if a == b or b == c or a == c:
            answer = max(answer, 1000 + arr[1] * 100)
        else:
            answer = max(answer, arr[2] * 100)
print(answer)