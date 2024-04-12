import heapq

def solution(n, k, enemy):
    qu = []
    sum = 0
    
    for i, now in enumerate(enemy):
        sum += now
        heapq.heappush(qu, (-now, now))
        if sum > n and k > 0:
            sum -= heapq.heappop(qu)[1]
            k -= 1
        elif sum > n and k <= 0:
            return i
        elif sum == n and k <= 0:
            return i+1
    return len(enemy)