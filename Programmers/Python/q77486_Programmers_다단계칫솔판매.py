def solution(enroll, referral, seller, amount):
    result = [0 for i in range(len(enroll))]
    follow = [-1 for i in range(len(enroll))]
    name_dict = {}

    index = 0
    for name in enroll:
        name_dict[name] = index
        index += 1

    for i in range(len(referral)):
        if referral[i] != '-':
            target = name_dict[referral[i]]
            follow[i] = target

    for i in range(len(seller)):
        start = name_dict[seller[i]]
        money = amount[i] * 100
        send_money(follow, result, money, start)

    return result


def send_money(follow, result, money, me):
    lead = follow[me]
    tax = int(money / 10)
    result[me] += money - tax

    if lead == -1 or tax == 0:
        return
    else:
        send_money(follow, result, tax, lead)