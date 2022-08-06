def solution(n, computers):
    answer = 0
    visited = [False for i in range(n)]

    for i in range(n):
        if not visited[i]:
            visited[i] = True
            findNetwork(i, computers, visited)
            answer += 1

    return answer


def findNetwork(now, computers, visited):
    for next in range(len(computers[now])):
        if computers[now][next] == 1 and not visited[next]:
            visited[next] = True
            findNetwork(next, computers, visited)
            


print(solution(3, [[1, 1, 0], [1, 1, 1], [0, 1, 1]]))