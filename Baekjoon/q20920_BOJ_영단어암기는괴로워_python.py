import sys

N,M = map(int, sys.stdin.readline().split(' '))
wordDict = dict()

for n in range(0,N):
    word = sys.stdin.readline().strip()
    if(len(word) >= M):
        if(wordDict.get(word) is None):
            wordDict[word] = [-1, -len(word), word]
        else:
            wordDict[word][0] -= 1

answer = sorted(wordDict.items(), key = lambda x : (x[1][0], x[1][1], x[1][2]))

str = ''
for i in range(0, len(answer)):
    str += (answer[i][0] + '\n')

print(str)