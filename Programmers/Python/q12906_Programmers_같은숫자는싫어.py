def solution(arr):
    answer = []
    before = -1
    
    for i in range(len(arr)):
        if arr[i] != before:
            before = arr[i]
            answer.append(before)
    
    return answer