def solution(s):
    # strArr = s.split('')
    strArr = list(s)

    answer = len(strArr)

    for i in range(1, len(strArr)//2 + 1):
        count = i
        idx = 0
        duple = 0
        for now in range(i, len(strArr) - (len(strArr) % i), i ):
            flag = True
            for j in range(0, i):
                if (strArr[idx + j] != strArr[now + j]):
                    flag = False
                    break
            if (flag):
                if(duple == 0):
                    duple = 2
                else:
                    duple +=1
            else :
                idx = now

                if (duple // 100 != 0):
                    count += 3
                elif (duple // 10 != 0):
                    count += 2
                elif (duple != 0):
                    count+=1
                count += i
                duple = 0
        if(duple // 100 != 0):
            count += 3
        elif (duple // 10 != 0):
            count += 2
        elif (duple != 0):
            count+=1
        
        duple = 0
        answer = min(answer, count + (len(strArr) % i))

    return answer

input = ["aabbaccc","ababcdcdababcdcd","abcabcdede","abcabcabcabcdededededede","xababcdcdababcdcd"]

for i in range(5):
    print(solution(input[i]))
