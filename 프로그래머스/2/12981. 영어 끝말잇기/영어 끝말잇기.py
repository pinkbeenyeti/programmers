def solution(n, words):
    answer = []
    tree = []
    
    now = words[0]
    tree.append(now)
    
    for i in range(1, len(words)):
        word = words[i]
        if now[-1] != word[0] or word in tree:
            print(now, words[i])
            if (i+1)%n == 0:
                answer.append(n)
            else:
                answer.append((i+1)%n)
            answer.append(i//n + 1)
            return answer
        now = words[i]
        tree.append(now)

    return [0, 0]