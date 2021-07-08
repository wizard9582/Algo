import sys

N = int(sys.stdin.readline().strip())

def makeWord(choosed, L):
    str = ''
    for l in range(0,L):
        str += chr(choosed[l] + ord('a'))
    print(str)
    return

def makePermutation(count, choosed, L):
    if(count == L):
        makeWord(choosed, L)
        return
    for i in range(0,26):
        if(chars[i] > 0):
            choosed[count] = i
            chars[i] -= 1
            makePermutation(count+1, choosed, L)
            chars[i] += 1

for n in range(0,N):
    chars = list(0 for i in range(0,26))
    input = sys.stdin.readline().strip()
    L = len(input)
    for l in range(0,L):
        idx = ord(input[l]) - ord('a')
        chars[idx] += 1

    makePermutation(0, list(0 for i in range(0,L)), L)