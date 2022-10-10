def solution(cards):
    answer = []

    for i in range(len(cards)):
        if cards[i] == 0:
            continue
        else:
            box = cards[i] - 1
            count = 1
            cards[i] = 0

            while True:
                if cards[box] == 0:
                    answer.append(count)
                    break

                else:
                    nbox = cards[box] - 1
                    count += 1
                    cards[box] = 0
                    box = nbox

    answer.sort(reverse=True)

    return answer[0] * answer[1] if len(answer) > 1 else 0


solution([8, 6, 3, 7, 2, 5, 1, 4])
