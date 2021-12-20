from collections import defaultdict

def solution(records):
    answer = []
    
    user_map = defaultdict(str)
    for record in records:
        parsed = record.split(' ')
        if parsed[0] == 'Enter':
            user_map[parsed[1]] = parsed[2]
        elif parsed[0] == 'Leave':
            pass
        elif parsed[0] == 'Change':
            user_map[parsed[1]] = parsed[2]

    for record in records:
        parsed = record.split(' ')
        if parsed[0] == 'Enter':
            answer.append(user_map[parsed[1]] + "님이 들어왔습니다.")
        elif parsed[0] == 'Leave':
            answer.append(user_map[parsed[1]] + "님이 나갔습니다.")
        elif parsed[0] == 'Change':
            pass

    return answer

if __name__ == '__main__':
    print(solution(["Enter uid1234 Muzi",
                    "Enter uid4567 Prodo",
                    "Leave uid1234",
                    "Enter uid1234 Prodo",
                    "Change uid4567 Ryan"]))