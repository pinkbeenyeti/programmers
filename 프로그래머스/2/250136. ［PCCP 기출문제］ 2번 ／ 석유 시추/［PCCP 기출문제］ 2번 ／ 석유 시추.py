from collections import deque

def solution(land):
    depth = len(land)
    oil_num = len(land[0])
    oils = [0 for i in range(oil_num)]
    directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    
    for y in range(depth):
        for x in range(oil_num):
            if land[y][x] == 0:
                continue
                
            qu = deque()        
            qu.append((y, x))
            land[y][x] = 0
            connect = set()
            amount = 0
            
            while qu:
                y1, x1 = qu.popleft()
                amount += 1
                connect.add(x1)
                
                for direction in directions:
                    dx, dy = direction
                    ny, nx = y1 + dy, x1 + dx
                    if 0 <= nx < oil_num and 0 <= ny < depth:
                        if land[ny][nx] == 1:
                            qu.append((ny, nx))
                            land[ny][nx] = 0
            
            for num in connect:
                oils[num] += amount
                
    return max(oils)