import math
import sys


n = int(sys.stdin.readline())
answer = []
mw = 10 ** 18

for a in range(1, math.ceil(math.sqrt(n)) + 1):
    if n % a == 0:
        d = n // a
        for b in range(1, d + 1):
            if d % b == 0:
                c = d // b
                s = a * b + a * c + b * c

                if s < mw:
                    mw = s
                    answer = [a, b, c]

print(' '.join([str(a) for a in answer]))