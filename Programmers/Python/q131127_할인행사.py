def solution(want, number, discount) -> int:
    answer = 0
    product = {}
    idx = 0

    for w in want:
        product[w] = idx
        idx += 1

    for i in range(10):
        if discount[i] in product:
            number[product[discount[i]]] -= 1

    for i in range(len(discount)):
        if checklist(number):
            answer += 1

        if discount[i] in product:
            number[product[discount[i]]] += 1

        if i + 10 < len(discount) and discount[i + 10] in product:
            number[product[discount[i + 10]]] -= 1

    return answer


def checklist(number) -> bool:
    for n in number:
        if n > 0:
            return False
    return True
