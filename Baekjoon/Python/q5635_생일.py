import sys


n = int(sys.stdin.readline())
young_s, old_s = '', ''
mn, mx = 20110000, 19890000

for i in range(n):
    name, d, m, y = sys.stdin.readline().strip().split()
    years = int(y) * 10000 + int(m) * 100 + int(d)

    if years < mn:
        old_s = name
        mn = years

    if years > mx:
        young_s = name
        mx = years


print(young_s + "\n" + old_s)