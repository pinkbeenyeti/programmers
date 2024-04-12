def solution(triangle):
    cnt = len(triangle)
    
    while cnt != 1:
        row = triangle[-2]
        ap = []
        
        for i in range(len(row)):
            num = max(triangle[-1][i], triangle[-1][i+1])
            ap.append(num + row[i])
            
        del triangle[-1]
        del triangle[-1]
        
        triangle.append(ap)
        cnt -= 1
        
    return triangle[0][0]