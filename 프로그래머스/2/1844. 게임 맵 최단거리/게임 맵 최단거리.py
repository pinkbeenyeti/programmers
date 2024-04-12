from collections import deque

def solution(maps):
    my = len(maps)
    mx = len(maps[0])
    dist = [[0]*mx for _ in range(my)]
    dirt = [(1, 0), (-1, 0), (0, 1), (0, -1)]
    
    qu = deque([(0, 0)])
    dist[0][0] = 1
    while qu:
        x, y = qu.popleft()
        for dr in dirt:
            p, q = dr
            nx, ny = x+p, y+q
            if 0 <= nx < mx and 0 <= ny < my:
                if maps[ny][nx] == 1 and dist[ny][nx] == 0:
                    dist[ny][nx] = dist[y][x] + 1
                    qu.append((nx, ny))
    if dist[my-1][mx-1] == 0:
        return -1
    else:
        return dist[my-1][mx-1]