from collections import deque

def solution(n, computers):
    answer = 0
    state = [1]*len(computers)
    print(state)
    q = deque()
    
    for i, val in enumerate(state):
        if val == 1:
            q.append(i)
            while q:
                now = q.popleft()
                for j, k in enumerate(computers[now]):
                    if j != now and k == 1 and state[j] == 1:
                        q.append(j)
                state[now] = 0
            answer += 1
            q.clear()
    return answer