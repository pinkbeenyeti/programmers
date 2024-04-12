from collections import deque

def count(word, k, n):
    cnt = 0
    for i in range(n):
        if word[i] != k[i]:
            cnt += 1
            
    if cnt==1:
        return True
    
    return False

def solution(begin, target, words):
    length = len(begin)
    cent = len(words)
    
    if target not in words:
        return 0
    
    qu = deque()
    qu.append((begin, 0))
    
    while True:
        a, cnt = qu.popleft()
        for word in words:
            if count(a, word, length):
                if word == target:
                    return cnt+1
                else:
                    if cnt == cent:
                        return 0
                    qu.append((word, cnt+1))
            
        