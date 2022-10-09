def solution(s):
    msg = list(s)

    idx = 0

    for i in range(len(msg)):
        if msg[i] == " ":
            idx = 0
        elif idx % 2 == 0:
            msg[i] = msg[i].upper()
            idx += 1
        else:
            msg[i] = msg[i].lower()
            idx += 1

    return ''.join(msg)


print(solution("try hello world"))
