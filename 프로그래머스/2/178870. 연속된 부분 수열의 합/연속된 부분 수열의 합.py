def solution(sequence, k):
    answer = [0, 2000000]
    first = last = 0
    sum1 = sequence[0]
    
    while True:
        if sum1 < k:
            last += 1
            if last == len(sequence):
                break
            sum1 += sequence[last]
        else:
            if sum1 == k:
                if last-first < answer[1]-answer[0]:
                    answer = [first, last]
            sum1 -= sequence[first]
            first+=1
            
    return answer