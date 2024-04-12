from collections import deque

def find(x, y, board, directions, limit):
    q = deque([(x, y)])
    cost = int(board[x][y])
    board[x][y] = "X"
    
    while q:
        cx, cy = q.popleft()

        for i in range(4):
            nx = cx + directions[i][0]
            ny = cy + directions[i][1]

            if 0 <= nx < limit[0] and 0 <= ny < limit[1] and board[nx][ny] != 'X':
                print(nx, ny)
                cost += int(board[nx][ny])
                board[nx][ny] = "X"
                q.append((nx, ny))
    print(cost)
    return cost  
        
def solution(maps):
    answer = []
    board = []
    directions = [(1,0), (-1,0), (0,1), (0,-1)]
    limit = [len(maps), len(maps[0])]
    print(limit)
    
    for row in maps:
        board.append(list(row))
        
    for x, row in enumerate(board):
        for y, val in enumerate(row):
            if val != "X":
                count = find(x, y, board, directions, limit)
                answer.append(count)

    if len(answer) == 0:
        answer.append(-1)
        return answer
    
    answer.sort()
    return answer