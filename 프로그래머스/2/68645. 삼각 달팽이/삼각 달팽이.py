def solution(n):
    answer = []
    cnt, num, now = 0, 0, 1
    x, y = 0, 0
    snail = [[0]*i for i in range(1, n+1)]
    snail[0][0] = 1
    for i in range(1, n+1): cnt+=i
    directions = [(0, 1), (1, 0), (-1, -1)]
    
    while now!=cnt:
        p, q = directions[num]
        if 0<=x+p<n and 0<=y+q<n and snail[y+q][x+p] == 0:
            x, y = x+p, y+q
            now+=1
            snail[y][x] = now
        else:
            num = (num+1)%3
    for row in snail: answer.extend(row)
    return answer