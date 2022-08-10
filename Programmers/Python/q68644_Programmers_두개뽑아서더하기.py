def solution(numbers):
    answer = []
    make = [False for i in range(201)]
    
    for i in range(len(numbers)):
        for j in range(i+1, len(numbers)):
            make[numbers[i] + numbers[j]] = True
    
    for i in range(len(make)):
        if make[i]:
            answer.append(i)
    
    return answer