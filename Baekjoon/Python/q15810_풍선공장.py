import sys

N,M = map(int, sys.stdin.readline().split(' '))
staffs = list(map(int, sys.stdin.readline().split(' ')))

left = 0
right = min(staffs) * M

while(left+1 < right):
    center = (left + right)//2
    balloon = 0

    for n in range(N):
        balloon += center//staffs[n]
    
    if(balloon >= M):
        right = center
    else :
        left = center

print(right)