def solution(coin, cards):
    n = len(cards)
    n1 = n // 3
    idxs = [-1] * (n+1)

    for i in range(n):
        c = cards[i]
        i -= n1
        if i < 0:
            idxs[c] = 0
        else:
            idxs[c] = 1 + i // 2

    free, one_needed, two_needed = 0, [], []

    for i in range(1, n // 2 + 1):
        i1, i2 = idxs[i], idxs[n+1-i]
        if i1 == 0:
            if i2 == 0:
                free += 1
            else:
                one_needed.append(i2)
        else:
            if i2 == 0:
                one_needed.append(i1)
            else:
                two_needed.append(max(i1, i2))

    one_needed.sort(reverse=True)
    two_needed.sort(reverse=True)

    curr = free
    while coin and curr < n1:
        if one_needed and one_needed[-1] <= curr + 1:
            coin -= 1
            curr += 1
            one_needed.pop()
        elif coin == 1:
            break
        elif not two_needed or two_needed[-1] > curr + 1:
            break
        else:
            coin -= 2
            curr += 1
            two_needed.pop()

    return curr + 1