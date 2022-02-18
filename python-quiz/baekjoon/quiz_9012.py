def solution(ps):
    if len(ps) < 2: return "NO"
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


# 강의 풀이
def solution2():
    for _ in range(int(input())):
        stack = []
        isVPS = True
        for ch in input():
            if ch == '(':
                stack.append(ch)
            else:
                if stack:
                    stack.pop()
                else:
                    isVPS = False
                    break

        if stack:
            isVPS = False

        print('YES' if isVPS else 'NO')



if __name__ == "__main__":
    main()
    # solution2()