import sys
import itertools

def calc(list):
    sum = 0
    for i in range(1, len(list)):
        sum += abs(list[i] - list[i-1])
    return sum

N = int(sys.stdin.readline().strip())
numbers = list(map(int, sys.stdin.readline().split(' ')))
permutation = list(itertools.permutations(numbers,N))
answer = 0

for i in range(0, len(permutation)):
    result = calc(permutation[i])
    if(result > answer):
        answer = result

print(answer)