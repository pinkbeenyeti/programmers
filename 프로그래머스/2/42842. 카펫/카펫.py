import math
def solution(brown, yellow):
    a = ((brown-4)+math.sqrt((brown-4)**2-16*yellow))/4
    b = yellow / a
    
    return [a+2, b+2]