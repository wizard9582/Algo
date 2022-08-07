def solution(answers):
    pick = [[1, 2, 3, 4, 5], [2, 1, 2, 3, 2, 4, 2, 5], [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
    grade = [0, 0, 0]
    answer = []

    for i in range(len(answers)):
        if answers[i] == pick[0][i % 5]:
            grade[0] += 1
        if answers[i] == pick[1][i % 8]:
            grade[1] += 1
        if answers[i] == pick[2][i % 10]:
            grade[2] += 1

    max_grade = max(grade[0], max(grade[1], grade[2]))

    for i in range(3):
        if grade[i] == max_grade:
            answer.append(i + 1)

    return answer