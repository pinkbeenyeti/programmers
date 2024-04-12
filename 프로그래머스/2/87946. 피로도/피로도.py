from itertools import permutations
def solution(k, dungeons):
    answer = -1
    n = len(dungeons)
    orders = list(permutations([i for i in range(n)], n))
    
    for order in orders:
        tired = k
        count = 0
        for idx, num in enumerate(order):
            req, use = dungeons[num]
            if req > tired:
                break
            else:
                tired -= use
                count += 1
        if count > answer:
            answer = count
            
    return answer