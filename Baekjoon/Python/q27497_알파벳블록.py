import sys

N = int(sys.stdin.readline())
s1, s2 = [], []
stack = []

for i in range(N):
    s = sys.stdin.readline().strip()

    if s[0] == "3":
        if len(stack) == 0:
            continue
        if stack.pop():
            s1.pop()
        else:
            s2.pop()
    elif s[0] == "1":
        s1.append(s[2])
        stack.append(True)
    else:
        s2.append(s[2])
        stack.append(False)

if len(s1) + len(s2) == 0:
    print(0)
else:
    print(''.join([s2[i] for i in range(len(s2) - 1, -1, -1)]) + ''.join(s1))
