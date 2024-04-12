from collections import deque

def solution(n, wires):
    check = [[0]*(n+1) for _ in range(n+1)]
    diff = 200
    q = deque()
    
    for wire in wires:
        a, b = wire
        check[a][b] = 1
        check[b][a] = 1
        check[a][a] = 1
        check[b][b] = 1
    
    for wire in wires:
        a, b = wire
        check[a][b] = 0
        check[b][a] = 0
        
        q.append(1)
        graph = []
        while q:
            now = q.popleft()
            for num, val in enumerate(check[now]):
                if val == 1 and num not in graph:
                    graph.append(num)
                    q.append(num)
                        
        count = len(graph)
        count = abs(n - count*2)
        if count < diff:
            diff = count
        
        check[a][b] = 1
        check[b][a] = 1
        
    return diff