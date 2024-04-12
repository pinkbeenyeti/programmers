from itertools import product

def solution(numbers, target):
    answer = 0
    k = len(numbers)
    flags = list(product([-1, 1], repeat=k))
    
    for flag in flags:
        now = 0
        for i in range(k):
            now += flag[i] * numbers[i]
        if now == target:
            answer+=1
            
    return answer