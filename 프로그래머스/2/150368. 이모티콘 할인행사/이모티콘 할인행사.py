from itertools import product

def price(a, b):
    return int(a*(100-b)/100)

def solution(users, emoticons):
    iterator = [10, 20, 30, 40]
    sale = list(product(iterator, repeat = len(emoticons)))
    
    count = 0
    answer = 0
    
    for discount in sale:
        buffer = 0
        charge = 0
        for user in users:
            sale_lim, buy_lim = user
            money = 0
            for i, dis in enumerate(discount):
                if dis >= sale_lim:
                    money += price(emoticons[i], dis)
            if money >= buy_lim:
                buffer += 1
            else:
                charge += money
            money = 0
            
        if buffer > count:
            count = buffer
            answer = charge
        elif buffer == count and charge > answer:
            answer = charge
            
    return [count, answer]