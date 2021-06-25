n = int(input())
A = list(map(int, input().split(' ')))
B = list(map(int, input().split(' ')))

A.sort()
B.sort(reverse=True)

answer = 0

for i in range(0,n):
    answer += int(A[i]) * int(B[i])

print(answer)