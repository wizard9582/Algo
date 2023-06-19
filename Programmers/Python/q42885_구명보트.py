def solution(people, limit):
    answer, left, right = 0, 0, len(people) - 1
    people.sort()
    
    while left <= right:
        if people[left] + people[right] <= limit:
            left += 1
            right -= 1
        else:
            right -= 1
        answer += 1
    
    return answer