str = list(input())
answer = True
l = len(str)
i = 0

while(i < l):
    c = str[i]
    if(c == 'p'):
        i+=1
        if(i >= l or str[i] != 'i'):
            answer = False
            break
    elif(c == 'k'):
        i+=1
        if(i >= l or str[i] != 'a'):
            answer = False
            break
    elif(c=='c'):
        i+=1
        if(i >= l or str[i] != 'h'):
            answer = False
            break
        i+=1
        if(i >= l or str[i] != 'u'):
            answer = False
            break
    else:
        answer = False
        break
    i+=1

if(answer):
    print('YES')
else:
    print('NO')
