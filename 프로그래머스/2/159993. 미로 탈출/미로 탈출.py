from collections import deque

def findLoad(start, end, maps):
    x, y = start
    max_x, max_y = len(maps), len(maps[0])
    directions = ((1,0), (0,1), (-1,0), (0,-1))
    
    visited = set()
    que = deque([(x, y, 0)])
    
    while que:
        now_x, now_y, cnt = que.popleft()
        
        if (now_x, now_y) in visited:
            continue
        elif (now_x, now_y) == end:
            return cnt
        else:
            for dx, dy in directions:
                visited.add((now_x, now_y))
                
                if maps[now_x][now_y] == "X":
                    continue
                    
                next_x = now_x + dx
                next_y = now_y + dy
                
                if 0<=next_x<max_x and 0<=next_y<max_y:
                    que.append([next_x, next_y, cnt+1])
                    
    return -1
def solution(maps):
    spos, lpos, epos = None, None, None
    
    for i, row in enumerate(maps):
        if "S" in row:
            spos = (i, row.find("S"))
        if "L" in row:
            lpos = (i, row.find("L"))
        if "E" in row:
            epos = (i, row.find("E"))
    
    count1 = findLoad(spos, lpos, maps)
    count2 = findLoad(lpos, epos, maps)
    
    if count1 == -1 or count2 == -1:
        return -1
    
    return count1 + count2