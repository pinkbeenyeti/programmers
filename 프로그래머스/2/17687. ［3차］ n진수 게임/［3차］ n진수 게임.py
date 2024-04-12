def convert(num, n):
    string = ''
    
    if num == 0 :
        return '0'
    
    while num != 0:
        remain = num % n
        if remain >= 10:
            string += chr(remain+55)
        else:
            string += str(remain)
        num = num // n
        
    return string[::-1]
        
def solution(n, t, m, p):
    answer = ''
    number = 0
    length = 0
    
    while True:
        answer += convert(number, n)
        pi = len(answer)
        if pi >= t*m:
            print(answer)
            return answer[p-1:t*m:m]
        number += 1