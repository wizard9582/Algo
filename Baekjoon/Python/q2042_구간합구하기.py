import sys

N, M, K = map(int, sys.stdin.readline().split())
answer = []

w = 1
while w < N:
    w *= 2

seg = [0] * (w * 2)

for i in range(N):
    seg[w + i] = int(sys.stdin.readline())

for i in range(w - 1, 0, -1):
    seg[i] = seg[i * 2] + seg[i * 2 + 1]

for i in range(M + K):
    a, b, c = map(int, sys.stdin.readline().split())

    if a == 1:
        t = b + w - 1
        seg[t] = c
        while t > 1:
            t //= 2
            seg[t] = seg[t * 2] + seg[t * 2 + 1]

    else:
        s = 0
        b += w - 1
        c += w - 1

        while b <= c:
            if b % 2 == 1:
                s += seg[b]
                b += 1
            if c % 2 == 0:
                s += seg[c]
                c -= 1
            b //= 2
            c //= 2

        answer.append(s)

print("\n".join([str(a) for a in answer]))