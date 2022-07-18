
def makeSubset(idx, used):
    global size
    if(idx == size):
        printSubset(used)
        return
    
    used[idx] = False
    makeSubset(idx+1, used)
    used[idx] = True
    makeSubset(idx+1, used)

def printSubset(used):
    global size
    global number
    msg = "{ "
    for i in range(0,size):
        if(used[i]):
            msg += str(number[i])
            msg += " "
    msg += "}"
    print(msg)

number = [1,2,3,4,5,6]
size = 6

makeSubset(0, [False]*size)