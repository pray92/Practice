
def solution(absolutes, signs):
	answer = 0
	for x, y in zip(absolutes, signs):
		if y is True:
			answer += x
		else:
			answer -= x

	return answer

if __name__ is '__main__':
	print(solution([4, 7, 12], [True, False, True]))
	print(solution([1, 2, 3], [False, False, True]))