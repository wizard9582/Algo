import sys

nums = list()

def solution(num, idx):
    if(idx > 9) :
        return
    nums.append(num)
    for i in range(0, num%10):
        solution((num*10)+i, idx+1)



N = int(sys.stdin.readline())

if(N > 1023):
    print(-1)
else:
    for i in range(0,10):
        solution(i,0)
    nums.sort()
    print(nums[N-1])


