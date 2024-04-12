def rect(r, c, n, arr, answer):
    num = arr[r][c]
    
    for i in range(n):
        for j in range(n):
            if arr[r+i][c+j] != num:
                rect(r, c, n//2, arr, answer)
                rect(r+n//2, c, n//2, arr, answer)
                rect(r, c+n//2, n//2, arr, answer)
                rect(r+n//2, c+n//2, n//2, arr, answer)
                return
    
    answer[num]+=1

def solution(arr):
    answer = [0, 0]
    rect(0, 0, len(arr), arr, answer)
    return answer