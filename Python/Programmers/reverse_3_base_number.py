def solution(n):
	answer = ''
	while n > 0:
		n, m = divmod(n, 3)
		answer += str(m)

	return int(answer, 3)

if __name__ is '__main__':
	print(solution(45))
	print(solution(125))