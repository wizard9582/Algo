import sys

answer = ""
t = int(sys.stdin.readline())
d = [300, 60, 10]

for i in range(3):
    c = t // d[i]
    answer += f"{c} "
    t -= c * d[i]

if t != 0:
    print("-1")
else:
    print(answer[:-1])