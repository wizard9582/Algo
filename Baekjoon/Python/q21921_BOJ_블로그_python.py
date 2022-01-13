import sys

N,X = map(int, sys.stdin.readline().split(' '))
visit = list(map(int, sys.stdin.readline().split(' ')))

answer = 0
count = 1

for x in range(X):
    answer += visit[x]

now = answer

for n in range(X,N):
    now -= visit[n-X]
    now += visit[n]

    if(now > answer):
        answer = now
        count = 1
    elif(now == answer):
        count += 1

if(answer == 0):
    print("SAD")
else:
    print(answer)
    print(count)