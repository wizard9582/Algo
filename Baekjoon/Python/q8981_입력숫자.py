import sys

n = int(sys.stdin.readline())
num1 = list(map(int, sys.stdin.readline().split()))
num2 = [0] * n

answer = f"{n}\n"
idx = 0

for i in range(n):
    while num2[idx] != 0:
        idx = (idx + 1) % n

    if num2[idx] == 0:
        num2[idx] = num1[i]
        idx = (idx + num1[i]) % n

num2 = [str(i) for i in num2]
answer += " ".join(num2)
print(answer)
