import collections
import re

def is_palindrome(text : str) -> bool:
    strs = []
    # 대소문자 구분 X
    # 영문자, 숫자만을 대상으로 함
    for char in text:
        if char.isalnum():
            strs.append(char.lower())
    
    while len(strs) > 1:
        if strs.pop(0) != strs.pop():
            return False
    return True

def is_palindrome_optimized(text : str) -> bool:
    strs: Deque = collections.deque()

    for char in text:
        if char.isalnum():
            strs.append(char.lower())
        
    while len(strs) > 1:
        if strs.popleft() != strs.pop():
            return False
    return True    

def is_palindrome_optimized_2(text: str) -> bool:
    text = text.lower()
    # 정규식으로 불필요한 문자 필터링
    text = re.sub('[^a-z0-9]', '', text)
    return text == text[::-1]

if __name__ == "__main__":
    print(is_palindrome_optimized_2("A man, a plan, a canal : Panama"))
    print(is_palindrome_optimized_2("race a car"))