def solution(numbers, target):
    answer = 0
    n = len(numbers)
    
    def dfs(idx, s):
        nonlocal answer, target
        if idx == n:
            if target == s:
                answer += 1
            return
        
        dfs(idx + 1, s + numbers[idx])
        dfs(idx + 1, s - numbers[idx])
    
    dfs(0, 0)
    return answer