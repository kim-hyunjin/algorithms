def solution(tapeSize, leakedPositions):
    leakedPositions.sort()
    
    before = leakedPositions[0]
    usedTape = 1
    covered = 1
    for i in range(1, len(leakedPositions)):
        diff = leakedPositions[i] - before
        if diff + covered <= tapeSize:
            covered += diff
        else:
            usedTape += 1
            covered = 1
        before = leakedPositions[i]


    return usedTape

def main():
    numOfLeaking, tapeSize = map(int, input().split())
    leakedPositions = list(map(int, input().split()))
    answer = solution(tapeSize, leakedPositions)
    print(answer)

if __name__ == "__main__":
    main()