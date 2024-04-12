def solution(phone_number):
    length = len(phone_number)
    answer = phone_number[length-4:]
    answer = "*"*(length-4) + answer
    return answer