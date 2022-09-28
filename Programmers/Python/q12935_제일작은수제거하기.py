def solution(arr):
    t = float('inf')
    for i in range(len(arr)):
        if arr[i] < t:
            t = arr[i]

    arr.remove(t)

    return arr if len(arr) > 0 else [-1]