def solution(picks, minerals):
    answer = 0
    
    diaPick = {0: 1, 1: 1, 2: 1}
    ironPick = {0: 5, 1: 1, 2: 1}
    stonePick = {0: 25, 1: 5, 2: 1}
    pickTired = [diaPick, ironPick, stonePick]
    
    pickOrder = [index for index, count in enumerate(picks) for _ in range(count)]
    minerals = minerals[0:sum(picks)*5]
    sortMinerals = sorted(
        map(lambda chunk: [chunk.count("diamond"), chunk.count("iron"), chunk.count("stone")],
           [minerals[i:i+5] for i in range(0, len(minerals), 5)]),
        reverse=True
    )
    
    while pickOrder and sortMinerals:
        for mineral, count in enumerate(sortMinerals[0]):
            answer += count * pickTired[pickOrder[0]][mineral]
            
        del pickOrder[0]
        del sortMinerals[0]
        
    return answer
