def solution(n, left, right):
    answer = []
    for i in range(left, right+1):
        row = i // n
        col = i % n

        if row >= col:
            answer.append(row+1)
        elif row < col:
            answer.append(col+1)
    return answer