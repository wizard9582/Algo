from collections import deque

def isIn(x):
    if(1 <= x and x <= F):
        return True
    return False

def bfs(x):
    time[x] = 1
    queue = deque([x])

    while queue:
        now = queue.popleft()
        next = now + U
        if(isIn(next) and time[next] == 0):
            time[next] = time[now] + 1
            queue.append(next)
        next = now - D
        if(isIn(next) and time[next] == 0):
            time[next] = time[now] + 1
            queue.append(next)

F,S,G,U,D = map(int, input().split(' '))

if(S == G):
    print(0)
else :
    time = [0 for f in range(F+1)]
    bfs(S)

    if(time[G] == 0):
        print("use the stairs")
    else:
        print(int(time[G]) - 1)