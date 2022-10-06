a, b = map(int, input().strip().split(' '))

for i in range(b):
    line = ''
    for j in range(a):
        line += '*'
    print(line)