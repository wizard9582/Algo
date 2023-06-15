def solution(s):
    st = []
    
    for c in s:
        if len(st) > 0 and st[-1] == c:
            st.pop()
        else:
            st.append(c)
    
    return 1 if len(st) == 0 else 0