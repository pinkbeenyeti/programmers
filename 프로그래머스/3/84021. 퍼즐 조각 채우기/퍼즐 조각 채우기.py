from collections import deque

directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def blank(game, state):
    blanks = []
    maxy = len(game)
    maxx = len(game[0])
    
    for y, row in enumerate(game):
        for x, data in enumerate(row):
            if data == state:
                continue
            else:
                game[y][x] = state
                qu = deque()
                qu.append((y, x))
                temp = []
                temp.append([y, x])
                
                while qu:
                    y1, x1 = qu.popleft()
                    for move in directions:
                        p, q = move
                        if 0 <= x1 + p < maxx and 0 <= y1 + q < maxy and game[y1+q][x1+p] == 1 - state:
                            game[y1 + q][x1 + p] = state
                            temp.append([y1+q, x1+p])
                            qu.append((y1+q, x1+p))
                    
                blanks.append(temp)
    
    return(blanks)

def normal(target):
    for i, poses in enumerate(target):
        miny, minx = 90, 90
        for pos in poses:
            y, x = pos
            if y < miny:
                miny = y
            if x < minx:
                minx = x
        for j in range(len(poses)):
            target[i][j][0] -= miny
            target[i][j][1] -= minx
    
def rotate(arrays):
    n, k = 0, 0
    miy, mix = 99, 99
    
    for posi in arrays:
        y, x = posi
        n = max(n, x, y)
        
    for i in range(len(arrays)):
        k = arrays[i][0]
        arrays[i][0] = arrays[i][1]
        arrays[i][1] = n - k
        miy, mix = min(miy, arrays[i][0]), min(mix, arrays[i][1])
    
    for i in range(len(arrays)):
        arrays[i][0] -= miy
        arrays[i][1] -= mix

def compare(empty, puzzle):
    state = 1
    for i in range(4):
        rotate(puzzle)
        for p in puzzle:
            if p not in empty:
                state = 0
                break
            state = 1
        if state == 1:
            return 1

    return 0

def correct(board, puzzles):
    full, state, p = 0, 0, 0
    
    while puzzles:
        state = 0
        p = len(puzzles[0])
        for i, empty in enumerate(board):
            e = len(empty)
            if p == e:
                k = compare(empty, puzzles[0])
                if k == 1:
                    full += p
                    state = 1
                    del puzzles[0]
                    del board[i]
                    break
            
        if state == 0:
            del puzzles[0]
    
    return full
                
def solution(game_board, table):
    answer = -1
    
    board = blank(game_board, 1)
    puzzle = blank(table, 0)
    
    normal(board)
    normal(puzzle)
    
    answer = correct(board, puzzle)
    
    return answer