import copy

def div(a):
    for i in range(2, a):
        if a%i==0:
            a = i
            break
    return a

def solution(arr):
    d = len(arr)
    answer = 1
    arr.sort()
    
    while arr:
        mi = div(arr[0])
        for i, val in enumerate(arr):
            if (val%mi) == 0:
                arr[i] = val//mi
        arr.sort()
        
        while arr and arr[0] == 1:
            del arr[0]
            d -= 1
        
        answer *= mi
        if d != 0:
            mi = arr[0]

        print(arr)
    return answer