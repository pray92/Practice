# [1] : 각 리스트의 길이를 반환하는 함수
# Keyword : map, list, input
def solution(mylist):
    return list(map(len, mylist))

if __name__ == '__main__':
    map(input, [solution([[1], [2]]), solution([[1, 2], [3, 4], [5]])])

# [2] :  a, b 나눈 값과 나눈 몫 구하기
# note: 무조건 divmod를 사용하는게 좋은 방법은 아님
# 가독성이나 팀의 코드 스타일에 따라서 a // b, a % b와 같이 쓸 때가 더 좋을 수도 있음
# divmod의 경우 작은 숫자를 다룰 때는 a // b, a % b보다 느리나 큰 숫자를 다룰 때는 divmod가 더 빠름
# Keyword : divmod, *divmod
if __name__ == '__main__':
	a, b = 5, 2 # map(int, input().strip().split(' '))
	# print(a // b, a % b)
	print(*divmod(a, b)) # divmod : Tuple형 반환, *divmod 원소를 각 반환

# [3] : base 진법으로 표기된 숫자를 10진법 숫자로 출력
# Keyword : int(num : str, base : int)
if __name__ == '__main__':
    num, base = '1122', 3 # map(int, input().strip().split(' '))
    print(int(num, base))

# [4] : 문자열 좌측/가운데/우측 정렬
# Keyword: str.ljust(num : int), str.center(num : int), str.rjust(num : int)
if __name__ == '__main__':
	s, n = 'abc', 7 # map(input().strip().split(' '))
	n = int(n)
	print(s.ljust(n))
	print(s.center(n))
	print(s.rjust(n))


# [5] : 입력으로 0이 주어지면 소문자. 1로 주어지면 대문자를 사전순으로 출력
# NOTE : 파이썬에선 해당 데이터를 상수(constants)로 정의해놓았음
# Keyword : import string 
import string

if __name__ == '__main__':
	num = 1# int(input().strip())
	if num <= 0:
		print(string.ascii_lowercase)
	else:
		print(string.ascii_uppercase)
	# string.ascii_letters : a-zA-Z
	# string.digits : 0-9

# [6] : 원본을 유지한채, 정렬된 리스트 구하기
# note: sort의 경우 원본의 멤버 순서를 변경, sorted는 새로운 정렬된 멤버를 반환
# Keyword : sort, sorted
if __name__ == '__main__':
	list1 = [3, 2, 1]
	# list2 = [i for i in list1]
	# list2.sort()
	list2 = sorted(list1)
	print(list2, list1 is list2)

# [7] : 
# solution 함수는 이차원 리스트, mylist를 인자로 받습니다
# solution 함수는 mylist 원소의 행과 열을 뒤집은 한 값을 리턴해야합니다.
#
# note: zip(*iterables)는 각 iterables의 요소들을 모으는 이터레이터를 만듦
# 튜플의 이터레이터를 반환하는데, i 번째 튜플은 각 인자로 전달된 시퀀스나 이터러블의 i 번째 요소를 포함
#
# keyword : zip
def solution(mylist):
    return list(map(list, zip(*mylist)))

if __name__ == '__main__':
	print(solution([[1, 2, 3], [4, 5, 6], [7, 8, 9]]))
	# Key 리스트와 Value 리스트로 딕셔너리 생성
	animals = ['cat', 'dog', 'lion']
	sounds = ['meow', 'woof', 'roar']
	print(dict(zip(animals, sounds)))

# [8] : mylist의 i번째 원소와 i+1번째 원소의 차를 담은 일차원 리스트에 차례로 담아 리턴
# note: zip 함수에 서로 길이가 다른 list가 인자로 들어오는 경우, '길이가 짧은' 쪽 까지만 이터레이션이 이뤄짐
# keyword : zip
def solution(mylist : list):
    return [abs(x - y) for x, y in zip(mylist, mylist[1:])]

if __name__ == '__main__':
	print(solution([83, 48, 13, 4, 71, 11]))

# [9] : 이 리스트를 정수형 리스트로 바꾼 값을 리턴
# keyword : map(해답에선 map 활용)
def solution(mylist):
    return [int(x) for x in mylist]
	
if __name__ == '__main__':
	print(solution(['1', '100', '33']))

# [10] : 원소를 모두 이어붙인 문자열을 리턴
# keyword : {구분자}.join(iterable) -> i1{구분자}i2{구분자}...
def solution(mylist : list):
	return ''.join(mylist)
	
if __name__ == '__main__':
	print(solution(['1', '100', '33']))

# [11] : 별(*) 문자를 이용해 높이가 n인 삼각형을 출력
# keyword : join, iterable in list
if __name__ == '__main__':
	n = 3# int(input().strip())
	print('\n'.join(['*' * x for x in range(1, n + 1)]))

# [11-1] : 곱집합(Cartesizan product)
# note : 곱집합을 제공하는 모듈에 대한 예시
# keyword : itertool.product()
import itertools

if __name__ == '__main__':
	iterable1 = 'ABCD'
	iterable2 = '12345'
	iterable3 = 'xyz'

	print(list(itertools.product(iterable1, iterable2, iterable3)))

# [12] : mylist를 일차원 리스트로 만들어 리턴
def solution(my_list):
	# 방법 1 - sum 함수
	answer = sum(my_list, [])

	# 방법 2 - itertools.chain
	import itertools
	list(itertools.chain.from_iterable(my_list))

	# 방법 3 - itertools와 unpacking
	import itertools
	list(itertools.chain(*my_list))

	# 방법 4 - list comprehension 이용
	[element for array in my_list for element in array]

	# 방법 5 - reduce 함수 이용 1
	from functools import reduce
	list(reduce(lambda x, y: x+y, my_list))

	# 방법 6 - reduce 함수 이용 2
	from functools import reduce
	import operator
	list(reduce(operator.add, my_list))
	
	# 방법 7 - numpy 라이브러리의 flatten 이용(제한적, 각 원소의 길이가 동일해야 함)
	# import numpy as np
	# np.array(my_list, dtype = np.dtype).flatten().tolist()

	return answer


if __name__ == '__main__':
	print(solution([[1], [2]]))
	print(solution([['A', 'B'], ['X', 'Y'], ['1']]))
	