def solution(x):
	str_x = str(x)

	x_sum = sum([int(i) for i in str_x])

	return x % x_sum == 0

if __name__ == '__main__':
	print(solution(10))
	print(solution(12))
	print(solution(11))
	print(solution(13))