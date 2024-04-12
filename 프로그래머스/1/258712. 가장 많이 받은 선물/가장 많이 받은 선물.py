def solution(friends, gifts):
    table = dict()
    count = dict()
    present = dict()
    answer = 0
    
    for me in friends:
        table[me] = dict()
        count[me] = 0
        present[me] = 0
        for fr in friends:
            if me == fr:
                continue
            else:
                table[me][fr] = 0
    
    for gift in gifts:
        give, receive = gift.split(" ")
        table[give][receive] += 1
        count[give] += 1
        count[receive] -= 1
    
    for me in table:
        for fr in table[me]:
            a, b = table[me][fr],table[fr][me]
            if a > b:
                present[me] += 1
            elif a == b and a != -1:
                table[me][fr], table[fr][me] = -1, -1
                c, d = count[me], count[fr]
                if c > d:
                    present[me] += 1
                elif d > c:
                    present[fr] += 1
    
    for key in present:
        if present[key] > answer:
            answer = present[key]
            
    print(table)
    print(count)
    print(present)
    return answer