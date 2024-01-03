import sys

n, m = map(int, sys.stdin.readline().split())
a = list(map(int, sys.stdin.readline().split()))
b = list(map(int, sys.stdin.readline().split()))
a.sort()
b.sort()

answer, ni, mi = 0, 0, 0

while ni < n and mi < m:
    if a[ni] == b[mi]:
        ni += 1
        mi += 1
    
    elif a[ni] > b[mi]:
        answer += 1
        mi += 1
    
    else:
        answer += 1
        ni += 1

answer += (n - ni) + (m - mi)

print(answer)