def solution(n, s, a, b, fares):
    answer = 1e9
    floid = [[1e9]*(n+1) for _ in range(n+1)]
    
    for road in fares:
        x, y, fare = road
        floid[x][y] = fare
        floid[y][x] = fare
        floid[x][x] = 0
        floid[y][y] = 0
        
    for k in range(1, n+1):
        for i in range(1, n+1):
            for j in range(1, n+1):
                floid[i][j] = min(floid[i][j], floid[i][k] + floid[k][j])
    
    for j in range(1,n+1):
        answer = min(floid[s][j] + floid[j][a] + floid[j][b], answer)
    
    return answer