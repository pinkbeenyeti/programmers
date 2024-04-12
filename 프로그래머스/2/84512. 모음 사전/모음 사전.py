from itertools import product

def solution(word):
    words = "AEIOU"
    perm=[]
    for i in range(1, 6):
        perm.extend(list(map(''.join, product(words, repeat=i))))
    perm.sort()
    for i, var in enumerate(perm):
        if var == word:
            return i+1