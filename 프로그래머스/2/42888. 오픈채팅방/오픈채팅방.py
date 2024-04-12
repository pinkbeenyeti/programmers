def solution(record):
    answer = []
    stret = "님이 들어왔습니다."
    strlv = "님이 나갔습니다."
    
    tree = []
    uname = dict()
    
    for string in record:
        li = string.split(" ")
        command, uid = li[0], li[1]
        if command == "Change":
            uname[uid] = li[2]
        elif command == "Enter":
            answer.append([uid, stret])
            uname[uid] = li[2]
        else:
            answer.append([uid, strlv])
            
    result = []
    for val in answer:
        result.append(uname[val[0]]+val[1])
    return result