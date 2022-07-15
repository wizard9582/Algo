def solution(participant, completion):
    map = {}

    for i in completion :
        if(i in map):
            map[i] = map.get(i) + 1
        else : 
            map[i] = 1

    for i in participant:
        if(i in map and map[i] > 0):
            map[i] = map.get(i) - 1
        else : 
            return i


participant = [["leo", "kiki", "eden"], ["marina", "josipa", "nikola", "vinko", "filipa"], ["mislav", "stanko", "mislav", "ana"]]
completion = [["eden", "kiki"], ["josipa", "filipa", "marina", "nikola"], ["stanko", "ana", "mislav"]]

for i in range(0,3):
    print(solution(participant[i], completion[i]))