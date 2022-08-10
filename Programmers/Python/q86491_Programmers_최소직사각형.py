def solution(sizes):
    width = 0
    height = 0
    
    for size in sizes:
        w = size[0]
        h = size[1]
        
        if w < h:
            temp = h
            h = w
            w = temp
        
        if w > width:
            width = w
        if h > height:
            height = h   
    
    return width * height