import sys

N = int(sys.stdin.readline())
answer = 0
stack = []

for i in range(N):
    h = int(sys.stdin.readline())
    c = 1

    while stack and stack[-1][0] < h:
        answer += stack.pop()[1]

    if stack and stack[-1][0] == h:
        answer += stack[-1][1]
        c += stack.pop()[1]
        if stack:
            answer += 1

    elif stack:
        answer += 1

    stack.append([h, c])

print(answer)
