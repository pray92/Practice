import itertools

def solution(number, k):
	answer = '0'

	for num_list in set(itertools.combinations(number, len(number) - k)):
		num_str = ''.join(num_list)
		if int(num_str) > int(answer):
			answer = num_str

	return answer



if __name__ == '__main__':
	print(solution("1924", 2))
	print(solution("1231234", 3))
	print(solution("4177252841", 4))
	print(solution("121212121212", 3))