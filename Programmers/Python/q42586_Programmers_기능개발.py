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
        develop = progresses[index]
        count = 0
        flag = True

        for i in range(index, len(progresses)):
            progresses[i] -= develop
            if progresses[i] <= 0 and flag:
                count += 1
                index = i + 1
            else:
                flag = False

        answer.append(count)

    return answer