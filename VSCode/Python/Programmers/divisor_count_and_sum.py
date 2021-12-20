def get_divisor(num):
	return [x for x in range(1, num + 1) if num % x == 0]

def solution(left, right):
	answer = 0
	divisors = [get_divisor(x) for x in range(left, right + 1)]
	for ans_list in divisors:
		if len(ans_list) % 2 == 0:
			answer += ans_list[-1]
		else:
			answer -= ans_list[-1]

	return answer

if __name__ == '__main__':
	print(solution(13, 17))
	print(solution(24, 27))