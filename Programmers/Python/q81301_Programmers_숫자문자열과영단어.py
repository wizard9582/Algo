def solution(s):
    answer = 0
    i = 0
    # numList = []
    while(i < len(s)):
        character = ord(s[i])
        num = 0
        if(48 <= character and character <= 57):
            num = int(s[i])
            i += 1
        else : 
            if(s[i] == 'z'): 
                num = 0
                i += 4
            elif(s[i] == 'o'):
                num = 1
                i += 3
            elif(s[i] == 'e'):
                num = 8
                i += 5
            elif(s[i] == 'n'):
                num = 9
                i += 4
            elif(s[i] == 't'):
                if(s[i+1] == 'w'):
                    num = 2
                    i += 3
                else : 
                    num = 3
                    i += 5
            elif(s[i] == 'f'):
                if(s[i+1] == 'o'):
                    num = 4
                    i += 4
                else : 
                    num = 5
                    i += 4
            else :
                if(s[i+1] == 'i'):
                    num = 6
                    i += 3
                else : 
                    num = 7
                    i += 5
        answer = answer * 10
        answer += num
        # numList.append(str(num))
    # print(numList)
    # numString = "".join(numList)
    # answer = int(numString)
    return answer

input = ["one4seveneight","23four5six7","2three45sixseven","123"]

for i in input:
    print(solution(i))
