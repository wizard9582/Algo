from collections import deque


def solution(n, edge):
    answer = 0
    adjList = [[] for i in range(n+1)]
    visited = [False]*(n+1)
    
    for i in edge:
        start = i[0]
        end = i[1]
        
        adjList[start].append(end)
        adjList[end].append(start)
    
    queue = deque()
    queue.append(1)
    visited[1] = True

    while(len(queue) != 0):
        answer = size = len(queue)
        print(queue)
        for i in range(size):
            start = queue.popleft()
            
            for e in adjList[start]:
                if(not visited[e]):
                    visited[e] = True
                    queue.append(e)
    
    return answer


n = 6
vertexs = [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]

print(solution(n,vertexs))