def makePermutation(count, picked, used):
    global size
    global number

    if(count == size):
        printPermutation(picked)
        return
    
    for i in range(0, len(number)):
        if(not used[i]):
            picked[count] = number[i]
            used[i] = True
            makePermutation(count+1, picked, used)
            used[i] = False
    

def printPermutation(picked):
    global size
    msg = "{ "
    for i in range(0,size):
            msg += str(picked[i])
            msg += " "
    msg += "}"
    print(msg)

number = [1,2,3,4,5,6]
size = 6

makePermutation(0, [0]*size, [False]*len(number))