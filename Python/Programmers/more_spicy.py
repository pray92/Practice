
def solution(scoville, K):
	scoville = list(filter(lambda x: x < K, sorted(scoville)))

	answer = 0

	

	return -1


if __name__ == '__main__':
	print(solution([1, 2, 3, 9, 10, 12], 7))