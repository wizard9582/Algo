def solution(n, arr1, arr2):
    answer = []

    for i in range(n):
        arr1[i] = arr1[i] | arr2[i]

    for i in range(n):
        num = n
        temp = []
        while num > 0:
            if arr1[i] % 2 == 1:
                temp.append("#")
            else:
                temp.append(" ")

            arr1[i] //= 2
            num -= 1
        answer.append(''.join(temp.__reversed__()))

    return answer