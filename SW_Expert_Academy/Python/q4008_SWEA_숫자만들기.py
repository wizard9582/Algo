class Operation:
    def __init__(self, plus, minus, multiple, divide):
        self._plus = plus
        self._minus = minus
        self._multiple = multiple
        self._divide = divide

def dfs(value, count, operation):
    global minValue
    global maxValue

    if(count == N):
        minValue = min(minValue, value)
        maxValue = max(maxValue, value)
        return
    
    if(operation._plus > 0):
        operation._plus -= 1
        dfs(value + number[count], count+1, operation)
        operation._plus += 1
    if(operation._minus > 0):
        operation._minus -= 1
        dfs(value - number[count], count+1, operation)
        operation._minus += 1
    if(operation._multiple > 0):
        operation._multiple -= 1
        dfs(value * number[count], count+1, operation)
        operation._multiple += 1
    if(operation._divide > 0):
        operation._divide -= 1
        dfs(int(value / number[count]), count+1, operation)
        operation._divide += 1

def createOperation(tempOp):
    operation = Operation(tempOp[0],tempOp[1],tempOp[2],tempOp[3])
    return operation

T = int(input())
for test_case in range(1, T + 1):
    minValue = 100_000_001
    maxValue = -100_000_001
    N = int(input())
    operation = createOperation(list(map(int, input().split())))
    number = list(map(int, input().split()))

    dfs(number[0], 1, operation)

    print("#{} {}".format(test_case, maxValue-minValue))
