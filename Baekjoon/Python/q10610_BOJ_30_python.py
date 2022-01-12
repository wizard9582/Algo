N = list(input())
N = sorted(N, reverse=True)

if N[-1] != '0' :
    print(-1)
else:
    sum = 0
    for i in N:
        sum += int(i)
    if sum % 3 != 0 :
        print(-1)
    else :
        print(''.join(N))
