import sys


N = int(sys.stdin.readline())
blocks = [int(sys.stdin.readline()) for _ in range(N)]


def get_area(left, right):
    if left == right:
        return blocks[left]

    mid = (left + right) // 2

    left_area = get_area(left, mid)
    right_area = get_area(mid + 1, right)

    l, r = mid, mid + 1
    min_h = min(blocks[l], blocks[r])
    mid_area = min_h * 2

    while left < l or r < right:
        if l == left or (r < right and blocks[l - 1] < blocks[r + 1]):
            r += 1
            min_h = min(min_h, blocks[r])

        else:
            l -= 1
            min_h = min(min_h, blocks[l])

        mid_area = max(mid_area, min_h * (r - l + 1))

    return max(max(left_area, right_area), mid_area)


print(get_area(0, N - 1))
