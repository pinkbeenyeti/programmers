def solution(bandage, health, attacks):
    time = [0 for i in range(1001)]
    mhealth, last, conti = health, 0, 0
    
    for attack in attacks:
        t, damage = attack
        time[t] = damage
        last = t
    
    print(time)
    
    for t, damage in enumerate(time):
        if health < mhealth and damage == 0:
            health += bandage[1]
            conti += 1
            if conti == bandage[0]:
                health += bandage[2]
                conti = 0
            if health >= mhealth:
                health = mhealth
        else:
            health -= damage
            conti = 0
        
        if t == last or health <= 0:
            break

    if health <= 0:
        return -1
    else:
        return health