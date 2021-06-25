E,S,M = map(int, input().split(' '))

year = 1

while (year-E)%15 !=0 or (year-S)%28 != 0 or (year-M)%19 != 0:
    year+=1

print(year)
