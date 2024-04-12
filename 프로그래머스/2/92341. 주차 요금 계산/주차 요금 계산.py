from datetime import datetime
import math

def timer(t1, t2):
    t1 = datetime.strptime(t1, "%H:%M")
    t2 = datetime.strptime(t2, "%H:%M")
    diff = (t2 - t1).seconds
    minute = (diff // 60) 
    
    return minute

def fee(fees, minute):
    if minute <= fees[0]:
        return fees[1]
    else:
        return fees[1] + math.ceil((minute - fees[0]) / fees[2]) * fees[3]

def solution(fees, records):
    answer = []
    car = dict()
    charge = dict()
    leng = len(records) - 1
    
    for string in records:
        li = string.split(" ")
        num = li[1]
        
        if num not in car:
            car[num] = 0
            charge[num] = 0
    
    while records:
        rec = records[0].split(" ")
        num = rec[1]
        
        if rec[2] == "IN":
            car[num] = rec[0]
        elif rec[2] == "OUT":
            charge[num] += timer(car[num], rec[0])
            car[num] = 0
        
        del records[0]
        
    for key in car:
        if car[key] != 0:
            charge[key] += timer(car[key], "23:59")
    
    charge = dict(sorted(charge.items()))
    for key in charge:
        answer.append(fee(fees,charge[key]))
        
    return answer