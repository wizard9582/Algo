def solution(board, moves):
    answer = 0
    besket = []

    for i in moves:
        for j in range(0, len(board)):
            if(board[j][i-1] != 0):
                pick = board[j][i-1]
                # print(pick)
                board[j][i-1] = 0

                if(len(besket) > 0 and besket[-1] == pick):
                    besket = besket[0: -1]
                    answer += 2
                else : 
                    besket.append(pick)
                break
    return answer


board = [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
moves = [1,5,3,5,1,2,1,4]
print(solution(board, moves))