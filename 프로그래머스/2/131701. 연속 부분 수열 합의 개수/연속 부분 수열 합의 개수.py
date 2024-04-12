def solution(elements):
    sorts = set()
    d = len(elements)
    
    for i in range(d):
        num = elements[i]
        sorts.add(num)
        for j in range(i+1, i+d):
            num += elements[(j%d)]
            sorts.add(num)
    return(len(sorts))