from collections import deque

def solution(queue1, queue2):
    answer = 0
    
    q1 = deque(queue1)
    q2 = deque(queue2)
    sum1 = sum(q1)
    sum2 = sum(q2)
    maxl = len(q1)
    
    if ((sum1 + sum2) % 2) != 0:
        return -1
    
    while q1 and q2:      
        if sum1 > sum2:
            a = q1.popleft() 
            q2.append(a)
            
            sum1 -= a
            sum2 += a
            answer += 1
            
        elif sum1 < sum2:
            a = q2.popleft() 
            q1.append(a)
            
            sum2 -= a
            sum1 += a
            answer += 1
            
        elif sum1 == sum2:
            return answer
        
        if answer > 300000:
            return -1
        
    return -1