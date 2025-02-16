import sys

def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)

T = int(sys.stdin.readline())
out = ""

for _ in range(T):
    M, N, x, y = list(map(int, sys.stdin.readline().split(' ')))
    answer = -1
    e = M * N // gcd(M, N)

    for i in range(0, e, M):
        if (i + x - y) % N == 0:
            answer = i + x
            break
    
    out += f"{answer}\n"
    
print(out)