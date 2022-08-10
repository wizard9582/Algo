def solution(a, b):
    month = [0,0,31,60,91,121,152,182,213,244,274,305,335]
    day = ['THU','FRI','SAT','SUN','MON','TUE','WED']

    daynum = month[a] + b
    answer = day[daynum % 7]
    return answer

solution(5,24)