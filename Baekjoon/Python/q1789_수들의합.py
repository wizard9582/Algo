import sys

s = int(sys.stdin.readline())
i = 1

while s > 0:
    s -= i
    if s <= i:
        break
    i += 1

print(i)