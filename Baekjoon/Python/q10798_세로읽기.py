import sys

answer = ""
arr = []
for i in range(5):
    arr.append(sys.stdin.readline().strip())
for i in range(15):
    for j in range(5):
        if len(arr[j]) > i:
            answer += arr[j][i]
print(answer)