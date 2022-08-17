def solution(progresses, speeds):
    answer = []

    for i in range(len(progresses)):
        remain = 100 - progresses[i]
        if remain % speeds[i] == 0:
            progresses[i] = remain // speeds[i]
        else:
            progresses[i] = (remain // speeds[i]) + 1

    index = 0
    
    while index < len(progresses):
        day = progresses[index]
        count = 0

        for i in range(index, len(progresses)):
            if progresses[i] <= day:
                count += 1
                index = i + 1
            else:
                break

        answer.append(count)

    return answer