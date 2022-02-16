def solution(ps):
    stack = []

    for bracket in ps:
        if (bracket == "("):
            stack.append(bracket)
        else:
            if (len(stack) == 0): return "NO"
            stack.pop()

    if len(stack) > 0: return "NO"

    return "YES"

def main():
    numOfPS = int(input())
    PSList = []
    for _ in range(numOfPS):
        PSList.append(input())

    for ps in PSList:
        print(solution(ps))

if __name__ == "__main__":
    main()