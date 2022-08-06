def solution(jobs):

    jobs.sort(key=lambda x: (x[0], x[1]))

    time = jobs[0][0]
    exec_time = 0
    index = 0
    heap = MinHeap()

    while True:
        while index < len(jobs):
            if jobs[index][0] <= time:
                heap.insert(jobs[index])
                index += 1
            elif len(heap.queue) == 0 and index < len(jobs):
                time = jobs[index][0]
            else:
                break

        task = heap.pop()
        if not task:
            break
        exec_time += time + task[1] - task[0]
        time += task[1]

    return int(exec_time / len(jobs))


class MinHeap(object):

    def __init__(self) -> None:
        self.queue = []

    def insert(self, n) -> None:
        index = len(self.queue)
        self.queue.append(n)
        while 0 <= index:
            pIndex = self.parent((index))
            if 0 <= pIndex and self.queue[pIndex][1] > self.queue[index][1]:
                self.swap(index, pIndex)
                index = pIndex
            else:
                break

    def pop(self):
        if len(self.queue) == 0:
            return False

        last = len(self.queue) - 1
        self.swap(0, last)
        front = self.queue.pop()
        self.sort(0)
        return front

    def sort(self, index):
        left = self.leftChild(index)
        right = self.rightChild(index)
        smaller = index

        if left < len(self.queue) and self.queue[smaller][1] > self.queue[left][1]:
            smaller = left
        if right < len(self.queue) and self.queue[smaller][1] > self.queue[right][1]:
            smaller = right

        if index != smaller:
            self.swap(index, smaller)
            self.sort(smaller)

    def swap(self, a, b) -> None:
        temp = self.queue[a]
        self.queue[a] = self.queue[b]
        self.queue[b] = temp

    def parent(self, index) -> int:
        return (index - 1) // 2

    def leftChild(self, index) -> int:
        return index * 2 + 1

    def rightChild(self, index) -> int:
        return index * 2 + 2


print(solution([[1, 9], [0, 3], [2,8], [4,10], [2, 6],[150,1]]))
