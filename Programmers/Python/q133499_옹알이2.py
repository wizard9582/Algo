def solution(babbling):
    answer = 0

    for b in babbling:
        idx = 0
        flag = -1
        while idx < len(b):
            if b[idx] == 'a':
                if flag != 0 and idx + 2 < len(b) and b[idx+1] == 'y' and b[idx + 2] == 'a':
                    flag = 0
                    idx += 3
                else:
                    flag = -1
                    break
            elif b[idx] == 'y':
                if flag != 1 and idx + 1 < len(b) and b[idx+1] == 'e':
                    flag = 1
                    idx += 2
                else:
                    flag = -1
                    break
            elif b[idx] == 'w':
                if flag != 2 and idx + 2 < len(b) and b[idx+1] == 'o' and b[idx + 2] == 'o':
                    flag = 2
                    idx += 3
                else:
                    flag = -1
                    break
            elif b[idx] == 'm':
                if flag != 3 and idx + 1 < len(b) and b[idx+1] == 'a':
                    flag = 3
                    idx += 2
                else:
                    flag = -1
                    break
            else:
                flag = -1
                break

        if flag != -1:
            answer += 1

    return answer

print(solution(	["ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"]))