def checkMaxNumber(cards, maxNumber):
    for card in cards:
        if (maxNumber - card) in cards:
            cards.remove(card)
            cards.remove(maxNumber - card)
            return True
    
    return False

def splitNextCards(handCards, nextCards, pairCards, noPairCards, maxNumber):
    for card in nextCards:
        if (maxNumber - card) in handCards:
            pairCards.append(card)
        else:
            noPairCards.append(card)
    
def checkPairCards(handCards, pairCards, coin, maxNumber):
    if coin < 1:
        return False
    
    if len(pairCards) != 0:
        card = pairCards[0]
        handCards.remove(maxNumber - card)
        pairCards.remove(card)
        return True
    else:
        return False

def checknoPairCards(noPairCards, coin, maxNumber):
    if coin < 2:
        return False
    
    if len(noPairCards) > 1:
         if checkMaxNumber(noPairCards, maxNumber):
            return True
        
    return False

def solution(coin, cards):
    answer, maxNumber = 0, len(cards)
    handCards, pairCards, noPairCards = cards[:maxNumber//3], [], []
    
    cards = cards[maxNumber//3:]
    while cards:
        #print("answer : ", answer, "coin : ", coin)
        #print("cards : ", cards)
        #print("handCards : ", handCards)
        #print("pairCards : ", pairCards)
        #print("noPairCards : ", noPairCards)
        #print("------------------")
        nextCards = cards[:2]
        splitNextCards(handCards, nextCards, pairCards, noPairCards, maxNumber+1)
        if checkMaxNumber(handCards, maxNumber+1): 
            answer+=1
        else:
            if checkPairCards(handCards, pairCards, coin, maxNumber+1):
                coin-=1
                answer+=1
            else:
                if checknoPairCards(noPairCards, coin, maxNumber+1):
                    coin-=2
                    answer+=1
                else:
                    answer+=1
                    break
        
        cards = cards[2:]
    
    if len(cards) == 0: answer+=1
    return answer