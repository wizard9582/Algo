def solution(s, n):
    msg = list(s)

    for i in range(len(msg)):
        if msg[i] == " ":
            continue
        else:
            c = ord(msg[i])
            msg[i] = chr(((c + n - 65) % 26) + 65) if c < 97 else chr(((c + n - 97) % 26) + 97)

    return ''.join(msg)

print(solution("AaZz", 25))