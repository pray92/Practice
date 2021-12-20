# Anagram: 문자를 재배열하여 다른 뜻을 가진 단어로 바꾸는 것
import collections

def group_anagrams(words):
    anagrams = collections.defaultdict(list)
    
    for word in words:
        # 정렬하여 딕셔너리에 추가
        # sorted -> Timsort 기반 리스트를 반환
        # sort -> In-place, 리스트를 반환하지 않고 리스트 자체를 바꿈
        anagrams[''.join(sorted(word))].append(word)
    return list(anagrams.values())


if __name__ == "__main__":
    words = ["eat", "tea", "tan", "ate", "nat", "bat" ]
    print(group_anagrams(words))
    