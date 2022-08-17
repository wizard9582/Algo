def solution(n):
    answer = []

    while n > 0:
        if n % 3 == 0:
            answer.append(4)
            n = (n // 3) - 1
        else:
            answer.append(n % 3)
            n = n // 3
    
    result = ""
    for i in range(len(answer)):
        addnum = answer[len(answer) - 1 - i]
        result += str(addnum)
    
    return result