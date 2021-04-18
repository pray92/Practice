def longest_palindrome_substring(word) -> int:
    # 해당 사항 없을 때 빠르게 반환
    if len(word) < 2 or word == word[::-1]:
        return word

    # Palindrome 판별 및 투 포인터 확장
    def expand(left, right):
        while   0 <= left and right < len(word) and word[left] == word[right]:
            left -= 1
            right += 1
        return word[left + 1:right]
    
    result = ''
    # 슬라이딩 윈도우 우측으로 이동
    for idx in range(len(word) - 1):
        # 짝수, 홀수를 고려한 예외 처리
        result = max(result,
                    expand(idx, idx + 1),
                    expand(idx, idx + 2), 
                    key=len)
    return result

if __name__ == "__main__":
    print(longest_palindrome_substring("abba"))
    print(longest_palindrome_substring("babad"))
    print(longest_palindrome_substring("cbbd"))
