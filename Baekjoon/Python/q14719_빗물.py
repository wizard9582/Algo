import sys

H, W = map(int, sys.stdin.readline().split())
blocks = list(map(int, sys.stdin.readline().split()))
lt, rt = [0] * W, [0] * W
mxl, mxr = 0, 0
for i in range(W):
    lt[i] = mxl
    mxl = max(mxl, blocks[i])
    rt[W - 1 - i] = mxr
    mxr = max(mxr, blocks[W - 1 - i])

print(sum([max(0, min(lt[i], rt[i]) - blocks[i]) for i in range(W)]))