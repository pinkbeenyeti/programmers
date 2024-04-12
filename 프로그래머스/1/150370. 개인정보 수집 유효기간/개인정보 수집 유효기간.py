def solution(today, terms, privacies):
    answer = []
    y, m, d = map(int, today.split("."))
    fd = y * 28 * 12 + m * 28 + d
    print(fd)
    legacy = dict()
    
    for te in terms:
        t, c = te.split(" ")
        legacy[t] = int(c)
    
    for idx, now in enumerate(privacies):
        day, ty = now.split(" ")
        ny, nm, nd = map(int, day.split("."))
        nm, nd = nm + legacy[ty], nd - 1
        if nm > 12:
            if nm % 12 == 0:
                ny += (nm-1)//12
                nm = 12
            else:
                ny += nm//12
                nm = nm % 12
        if nd == 0:
            nd = 28
            nm -= 1
                
        comd = ny * 28 * 12 + nm * 28 + nd
        print(ny, nm, nd)
        print(comd)
        
        if fd > comd:
            answer.append(idx+1)
    
    return answer

        