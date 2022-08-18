def solution(survey, choices):
    typedict = {'R': 0, 'T': 1, 'C': 2, 'F': 3, 'J': 4, 'M': 5, 'A': 6, 'N': 7}
    point = [0, 0, 0, 0, 0, 0, 0, 0]
    answer = ''

    for i in range(len(survey)):
        positive = typedict[survey[i][1]]
        negative = typedict[survey[i][0]]

        if choices[i] < 4:
            point[negative] += 4 - choices[i]
        elif choices[i] > 4:
            point[positive] += choices[i] - 4

    if point[0] < point[1]:
        answer += 'T'
    else:
        answer += 'R'
    if point[2] < point[3]:
        answer += 'F'
    else:
        answer += 'C'
    if point[4] < point[5]:
        answer += 'M'
    else:
        answer += 'J'
    if point[6] < point[7]:
        answer += 'N'
    else:
        answer += 'A'

    return answer
