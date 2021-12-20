import collections

# 가변 변수(list)를 원소로 둔 list 중복 예외 처리를 위한 함수
def has_duplicates(seq):
	has_list = len(list(filter(lambda x: type(x) == list, seq))) > 0
	if has_list:
		seen = []
		unique_list = [x for x in seq if x not in seen and not seen.append(x)]
		return len(seq) != len(unique_list)
	return len(seq) != len(set(seq))

if __name__ == '__main__':
	# has_duplicates
	print(has_duplicates([1,2,3,4,5,5,6,2,3]))
	print(has_duplicates([1,2,3,4,5]))
	print(has_duplicates([[0, 1], [1, 1], [0, 1], 1, 0]))
	print(has_duplicates([[0, 1], [1, 1], [0, 2], 1, 0]))