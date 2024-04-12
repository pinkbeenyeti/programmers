def limit(x, y, xl, yl):
    if x == xl:
        x = 0
    elif x == -1:
        x = xl-1
    elif y == yl:
        y = 0
    elif y == -1:
        y = yl-1
    
    return x, y
        
def S(x, y, nowdic, xl, yl):
    p, q = nowdic
    x += p
    y += q
    
    x, y = limit(x, y, xl, yl)
    
    return x, y, nowdic

def L(x, y, nowdic, xl, yl):
    if nowdic == (1,0):
        y -= 1
        x, y = limit(x, y, xl, yl)
        return x, y, (0, -1)
    elif nowdic == (-1, 0):
        y += 1
        x, y = limit(x, y, xl, yl)
        return x, y, (0, 1)
    elif nowdic == (0, 1):
        x += 1
        x, y = limit(x, y, xl, yl)
        return x, y, (1, 0)
    elif nowdic == (0, -1):
        x -= 1
        x, y = limit(x, y, xl, yl)
        return x, y, (-1, 0)

def R(x, y, nowdic, xl, yl):
    if nowdic == (1, 0):
        y += 1
        x, y = limit(x, y, xl, yl)
        return x, y, (0, 1)
    elif nowdic == (-1, 0):
        y -= 1
        x, y = limit(x, y, xl, yl)
        return x, y, (0, -1)
    elif nowdic == (0, 1):
        x -= 1
        x, y = limit(x, y, xl, yl)
        return x, y, (-1, 0)
    elif nowdic == (0, -1):
        x += 1
        x, y = limit(x, y, xl, yl)
        return x, y, (1, 0)
    
def solution(grid):
    answer = []
    directions = {0:(0, 1), 1:(0, -1), 2:(1, 0), 3:(-1, 0)}
    x = y = 0
    cycle = 1
    xl, yl = len(grid[0]), len(grid)
    nowdic = (0, 0)
    visited = {}
    
    for i in range(xl):
        for j in range(yl):
            x = i
            y = j
            for key in directions:
                p, q = directions[key]
                nowdic = (p, q)
                visited[(x, y, nowdic)] = True
                x, y = limit(x+p, y+q, xl, yl)
                turn = grid[y][x]
                while True:
                    if turn == "S":
                        p_x, p_y = x, y
                        x, y, nowdic = S(x, y, nowdic, xl, yl)
                        if (p_x, p_y, nowdic) in visited: break
                        visited[(p_x, p_y, nowdic)] = True
                        cycle+=1
                    elif turn == "L":
                        p_x, p_y = x, y
                        x, y, nowdic = L(x, y, nowdic, xl, yl)
                        if (p_x, p_y, nowdic) in visited: break
                        visited[(p_x, p_y, nowdic)] = True
                        cycle+=1
                    elif turn == "R":
                        p_x, p_y = x, y
                        x, y, nowdic = R(x, y, nowdic, xl, yl)
                        if (p_x, p_y, nowdic) in visited: break
                        visited[(p_x, p_y, nowdic)] = True
                        cycle+=1
                    turn = grid[y][x]
            
                if cycle != 1:
                    answer.append(cycle)
                    x = y = 0
                    cycle = 1
                if xl == 1 and yl == 1:
                    answer.append(cycle)
                    x = i
                    y = j
                    cycle = 1
    
    answer.sort()             
    return answer