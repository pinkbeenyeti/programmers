def lisorting(numbers):
    num = numbers[-1]
    state = 0
    for idx in range(len(numbers)-2, -1, -1):
        now = numbers[idx]
        if now > num:
            numbers[idx+1] = now
        else:
            numbers[idx+1] = num
            state = 1
            break
            
    if state == 0:
        numbers[0] = num

def solution(operations):
    answer = []
    count = 0
    
    for operation in operations:
        li = operation.split(" ")
        if li[0] == "I":
            count += 1
            answer.append(int(li[1]))
            lisorting(answer)
            print(answer)
        elif li[0] == "D":
            if li[1] == "-1" and count > 0:
                del answer[0]
                count -= 1
            elif li[1] == "1" and count > 0:
                del answer[-1]
                count -= 1
    if count == 0:
        return [0, 0]
    
    return [answer[-1], answer[0]]