n = int(input())

zero = [0]
one = [1]

for i in range(1,n):
    one.append(zero[i-1])
    zero.append(zero[i-1]+one[i-1])

print(zero[n-1] + one[n-1])
