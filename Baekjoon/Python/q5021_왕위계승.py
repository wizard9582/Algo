import sys

ancestor = dict()
blood = dict()

def dfs(name):
    if(not name in ancestor):
        if (not name in blood):
            blood[name] = 0
            return blood[name]
        else : 
            return blood[name]

    father = ancestor[name][0]
    mother = ancestor[name][1]
    myblood = (dfs(father) + dfs(mother)) / 2
    blood[name] = myblood
    return myblood



N,M = map(int, sys.stdin.readline().split())

king = sys.stdin.readline().strip()

for i in range(0,N):
    me,father,mother = sys.stdin.readline().split()
    ancestor[me] = [father,mother]

blood[king] = 1.0

newking = 'nobody'
loyal = -1.0

for i in range(0,M):
    candidate = sys.stdin.readline().strip()
    myblood = dfs(candidate)
    if(myblood > loyal):
        loyal = myblood
        newking = candidate

print(newking)