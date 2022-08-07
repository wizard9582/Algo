def solution(n, lost, reserve):
    answer = 0
    student = [True for i in range(n)]
    spair = [False for i in range(n)]
    
    for i in lost:
        student[i-1] = False
    
    for i in reserve:
        if student[i-1]:
            spair[i-1] = True
        else:
            student[i-1] = True
        
    
    for i in range(n):
        if student[i]:
            answer += 1
        
        else:
            for j in range(-1,2):
                if 0 <= i+j < n and spair[i+j]:
                    spair[i+j] = False
                    answer += 1
                    break
    
    return answer