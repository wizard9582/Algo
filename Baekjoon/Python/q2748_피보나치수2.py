n = int(input())

arr = list()
arr.append(int(0))
arr.append(int(1))

for i in range(2,n+1):
    arr.append(arr[-2]+arr[-1])

print(arr[n])
