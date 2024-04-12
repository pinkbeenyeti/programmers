def solution(targets):

    targets.sort(key = lambda x: x[1])

    shoot = -1

    cnt = 0

    for target in targets:

        if target[0] > shoot :

            cnt += 1

            shoot = target[1]-0.5

    return cnt