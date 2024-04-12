def solution(data, col, row_begin, row_end):
    answer = 0
    data.sort(key = lambda x : (x[col-1], -x[0]))
    for i in range(row_begin-1, row_end):
        sum1 = 0
        for val in data[i]:
            sum1 += val%(i+1)
        answer ^= sum1
    
    return answer