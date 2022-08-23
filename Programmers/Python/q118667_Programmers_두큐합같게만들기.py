from collections import deque


def solution(queue1, queue2):
    left = sum(queue1)
    lqueue = deque(queue1)
    right = sum(queue2)
    rqueue = deque(queue2)
    limit = 2 * (len(queue1) + len(queue2))
    count = 0

    if (left + right) % 2 == 1:
        return -1

    while count < limit:

        if left == right:
            return count

        if left < right:
            gap = rqueue.popleft()
            left += gap
            right -= gap
            lqueue.append(gap)
        else:
            gap = lqueue.popleft()
            right += gap
            left -= gap
            rqueue.append(gap)

        count += 1
    return -1


print(solution([3, 2, 7, 2], [4, 6, 5, 1]))
