def solution(n, money):

    dp = [0 for _ in range(n+1)]
    dp[0] = 1 # 초기 조건 

    for num in money: # O(100)
        for amount in range(num, n+1): # O(100000)
            dp[amount] += dp[amount-num]
    # O(100 x 100000)
    return dp[n]