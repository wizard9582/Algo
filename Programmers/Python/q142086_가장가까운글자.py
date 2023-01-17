def solution(s):
    index = [-1 for i in range(26)]
    answer = []
    
    for i in range(len(s)):
        t = ord(s[i]) - 97
        if index[t] == -1:
            answer.append(-1)
            index[t] = i
        else:
            answer.append(i - index[t])
            index[t] = i
            
    return answer