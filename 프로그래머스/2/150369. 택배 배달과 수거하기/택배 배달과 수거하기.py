def solution(cap, n, deliveries, pickups):
    dl = n
    pk = n
    
    now_dl = now_pk = 0
    
    answer = 0
    
    for i in range(dl-1,0,-1):
        if deliveries[i] != 0:
            answer += 2*(i+1)
            break
        if pickups[i] != 0:
            answer += 2*(i+1)
            break
        
    while deliveries or pickups:
        while dl != 0:
            k = deliveries[-1]
            
            if now_dl + k <= cap:
                now_dl += k
                dl -= 1
                del deliveries[-1]
            else:
                deliveries[-1] -= (cap - now_dl)
                now_dl = 0
                break
                
            if dl == 0:
                break
                
        while pk != 0:
            k = pickups[-1]
            
            if now_pk + k <= cap:
                now_pk += k
                pk -= 1
                del pickups[-1]
            else:
                pickups[-1] -= (cap - now_pk)
                now_pk = 0
                break
                
            if pk == 0:
                break
                
        answer += 2*max(len(deliveries), len(pickups))
    
    return answer