def solution(numbers, hand):
    distance = [[3,1,0,1,2,1,2,3,2,3,4,4],[2,2,1,2,1,0,1,2,1,2,3,3],[1,3,2,3,2,1,2,1,0,1,2,2],[0,4,3,4,3,2,3,2,1,2,1,1]]
    # 순서대로 2,5,8,0과 각 버튼(0~9,*,#)의 거리
    flag = (hand == "right")
    left = 10
    right = 11
    answer = ''

    for i in numbers :
        if(i == 1 or i == 4 or i == 7):
            left = i
            answer += 'L'
        elif(i == 3 or i == 6 or i == 9):
            right = i
            answer += 'R'
        else : 
            target = 0
            if(i == 5):
                target = 1
            if(i == 8):
                target = 2
            if(i == 0):
                target = 3
            
            if(distance[target][left] == distance[target][right]):
                if(flag) : 
                    right = i
                    answer += 'R'
                else : 
                    left = i
                    answer += 'L'
            elif(distance[target][left] < distance[target][right]):
                    left = i
                    answer += 'L'
            else : 
                    right = i
                    answer += 'R'
    return answer

numbers = [[1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5],[7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2],[1, 2, 3, 4, 5, 6, 7, 8, 9, 0]]
hand = ["right", "left", "right"]

for i in range(0,3):
    print(solution(numbers[i],hand[i]))