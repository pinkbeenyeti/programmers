import math

def solution(storey):
    answer = 0
    while storey!=0:
        digit = storey%10
        
        if storey < 10:
            if storey <= 5:
                answer += storey
                break
            else:
                answer += 10 - storey + 1
                break
                
        if digit < 5:
            answer += digit
            storey = (storey-digit)//10
        elif digit == 5:
            storey = (storey - digit)//10
            if storey % 10 >= 5:
                storey += 1
                answer += 10 - digit
            else:
                answer += digit
        else:
            answer += 10 - digit
            storey = (storey - digit) // 10 + 1
                
            
    return answer