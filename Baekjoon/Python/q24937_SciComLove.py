import sys

N = int(sys.stdin.readline()) % 10
s = "SciComLove"

print(s[N:] + s[:N])