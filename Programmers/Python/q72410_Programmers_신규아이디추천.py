def solution(new_id):
    
    id = step1(new_id)
    id = step2(id)
    id = step3(id)
    id = step4(id)
    id = step5(id)
    id = step6(id)
    id = step7(id)

    answer = ""
    for i in id:
        answer += i
    return answer

def step1(id):
    result = []
    for i in id:
        character = ord(i)
        if(65 <= character and character <= 90):
            result.append(chr(character + 32))
        else:
            result.append(i)

    return result

def step2(id):
    result = []
    for i in id:
        character = ord(i)
        if((97 <= character and character <= 122) or (48 <= character and character <= 57) or character == 45 or character == 46 or character == 95):
            result.append(i)

    return result

def step3(id):
    result = []
    before = ''
    for i in id:
        if(before == '.' and i == '.'):
            continue
        else :
            result.append(i)
            before = i

    return result

def step4(id):
    if(len(id) > 0 and id[0] == '.'):
        id = id[1:]
    if(len(id) > 0 and id[-1] == '.'):
        id = id[0:-1]
    return id

def step5(id):
    if(len(id) == 0):
        return ['a']
    return id

def step6(id):
    if(len(id) > 15):
        id = id[0:15]
        if(len(id) > 0 and id[-1] == '.'):
            id = id[0:-1]
    return id

def step7(id):
    while(len(id) < 3):
        id.append(id[-1])
    return id


input = ["...!@BaT#*..y.abcdefghijklm","z-+.^.","=.=","123_.def","abcdefghijklmn.p"]
# input = ["...!@BaT#*..y.abcdefghijklm"]

for i in range(len(input)):
    print(solution(input[i]))
