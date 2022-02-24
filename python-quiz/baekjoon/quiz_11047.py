import math

def solution(coins: list, target: int):
    remain = target
    numOfUsedCoin = 0
    while remain != 0:
        biggestCoin = coins.pop()
        numOfUsedCoin += math.floor(remain / biggestCoin)
        remain = remain % biggestCoin

    return numOfUsedCoin

def main():
    N, target = map(int, input().split())
    coins = []
    for _ in range(N):
        coins.append(int(input()))
    
    print(solution(coins, target))

if __name__ == "__main__":
    main()