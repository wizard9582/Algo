import sys

N = int(sys.stdin.readline())
member = list(map(int, sys.stdin.readline().split(' ')))
member.sort()

answer = 0

for n in range(0, N-2):
    if member[n] > 0 : break
    left = n+1
    right = N-1
    idx = N
    goal = - member[n]

    while left < right:
        sum = member[left]+ member[right]

        if sum == goal:
            if member[left] == member[right]:
                answer += right - left
            else:
                if idx > right:
                    idx = right
                    while idx > left and member[idx - 1] == member[right]:
                        idx -= 1
                answer += right - idx + 1
            left += 1
        elif sum < goal:  
            left += 1
        else:
            right -= 1
print(answer)