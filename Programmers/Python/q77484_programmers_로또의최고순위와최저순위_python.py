def solution(lottos, win_nums):
    grade = [ 6, 6, 5, 4, 3, 2, 1 ]
    answer = []
    p = 0
    c = 0
    
    for i in range(6):
        if(lottos[i] == 0):
            p+=1
        else:
            for j in range(6):
                if(lottos[i] == win_nums[j]):
                    c+=1
    answer.append(grade[p+c])
    answer.append(grade[c])
    
    return answer

lottos = [ 44, 1, 0, 0, 31, 25 ]
win_nums = [ 31, 10, 45, 1, 6, 19 ]

print(solution(lottos, win_nums))