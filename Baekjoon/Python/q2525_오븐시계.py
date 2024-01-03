import sys

h, m = sys.stdin.readline().split()
h, m = int(h), int(m)
g = int(sys.stdin.readline())

gh = g // 60
m += g % 60

if m >= 60:
    h += 1
    m -= 60

h = (h + gh) % 24

print(f"{h} {m}")