import sys


sh, sm = map(int, sys.stdin.readline().split())
eh, em = map(int, sys.stdin.readline().split())
t = int(sys.stdin.readline())
answer = 0

while True:

    if sh // 10 == t or sh % 10 == t or sm // 10 == t or sm % 10 == t:
        answer += 1

    if sh == eh and sm == em:
        break
        
    sm += 1
    if sm == 60:
        sh += 1
        sm = 0

print(answer)