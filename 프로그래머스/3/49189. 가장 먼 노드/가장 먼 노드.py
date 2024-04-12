from collections import deque

def solution(n, edge):
    check = [[] for _ in range(n+1)]
    dist = [0 for _ in range(n+1)]
    
    for vertex in edge:
        a, b = vertex
        check[a].append(b)
        check[b].append(a)
    
    q = deque()
    q.append(1)
    tree = set()
    tree.add(1)
    
    while q:
        now = q.popleft()
        for val in check[now]:
            if val not in tree:
                dist[val] = dist[now] + 1
                q.append(val)
                tree.add(val)

    return dist.count(max(dist))