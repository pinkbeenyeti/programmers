import math

def binary(n, k):
    result = ""
    
    while n > 0:
        n, mod = divmod(n, k)
        result += str(mod)
    
    return result[::-1]

def prime(n):
    if n == 2:
        return True
    elif n == 1:
        return False
    
    for i in range(2, int(math.sqrt(n))+1):
        if n%i == 0:
            return False
        
    return True

def solution(n, k):
    answer = 0
    li = binary(n, k).split("0")
    
    for num in li:
        if num == "":
            continue
        else:
            if prime(int(num)):
                answer+=1
                
    return answer