import sys

# 내 풀이
def solution(books):
    dic = {}
    for book in books:
        if book in dic:
            dic[book] += 1
        else:
            dic[book] = 1

    sorted_dic = sorted(dic.items(), key=lambda item: item[1], reverse=True)
    mostSelled = []
    max = 0
    for book in sorted_dic:
        if book[1] >= max:
            max = book[1]
            mostSelled.append(book[0])
    
    mostSelled.sort()
    return mostSelled[0]

# 강좌 풀이
def solution2(books):
    d = dict()
    for book in books:
        if book in d:
            d[book] += 1
        else:
            d[book] = 1

    mostSelledCnt = max(d.values())
    candidate = []
    for k, v in d.items():
        if v == mostSelledCnt:
            candidate.append(k)

    return sorted(candidate)[0]

def main():
    N = int(input())
    books = []
    for _ in range(N):
        books.append(sys.stdin.readline())
    
    print(solution(books))

if __name__ == "__main__":
    main()