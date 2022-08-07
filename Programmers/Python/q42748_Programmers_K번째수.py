def solution(array, commands):
    answer = []

    for command in commands:
        start = command[0]
        end = command[1]
        target = command[2]

        arr = array[start-1:end]
        arr.sort()
        answer.append(arr[target-1])

    return answer

print(solution([1, 5, 2, 6, 3, 7, 4], [[2, 5, 3], [4, 4, 1], [1, 7, 3]]))