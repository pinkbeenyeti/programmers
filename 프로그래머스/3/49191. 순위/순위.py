def solution(n, results):
    answer = 0
    arrays = [[2 if i == j else 0 for i in range(n)] for j in range(n)]
    
    for result in results:
        w, l = result
        arrays[w-1][l-1], arrays[l-1][w-1] = 1, -1
    
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if arrays[i][k] == 1 and arrays[k][j] == 1:
                    arrays[i][j] = 1
                    arrays[j][i] = -1
    
    for row in arrays:
        state = 0
        for val in row:
            if val == 0:
                state = 1
                break
        if state == 0:
            answer+=1
            
    return answer