
# 1. 로그의 가장 앞 부분은 '식별자'
# 2. 문자로 구성된 로그가 숫자 로그보다 앞에 온다
# 3. 식별자는 순서에 영향을 끼치지 않지만, 문자 동일 시
#    식별자 순으로 함
# 4. 숫자 로그는 입력 순대로 함
def reorder(logs):
    letters, digits = [], []
    for log in logs:
        if log.split()[1].isdigit():
            digits.append(log)
        else:
            letters.append(log)
            
    # 2개의 키를 람다 표현식으로 정렬
    letters.sort(key=lambda x: (x.split()[1:], x.split()[0]))
    return letters + digits

if __name__ == "__main__":
    logs = ["let1 art can", 
            "let3 art zero",
            "let2 own kit dig",
            "dig1 8 1 5 1",
            "dig2 3 6"]
    print(reorder(logs))