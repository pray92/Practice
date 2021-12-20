import heapq
from collections import deque

def solution(scoville, K):
	filtered_scoville = list(filter(lambda x: x < K, sorted(scoville)))
	heapq.heapify(filtered_scoville)

	mixable = len(scoville) != len(filtered_scoville)

	answer = 0

	while len(filtered_scoville) >= 2:
		food1 =	heapq.heappop(filtered_scoville)
		food2 =	heapq.heappop(filtered_scoville)

		mixed = food1 + (food2) * 2
		answer += 1

		heapq.heappush(filtered_scoville, mixed)

		if filtered_scoville[0] >= K:
			return answer
				
	last_food = filtered_scoville[0]
	if last_food >= K:
		return answer
	
	if mixable:
		return answer + 1

	return -1


if __name__ == '__main__':
	print(solution([1, 2, 3, 9, 10, 12], 7))
	print(solution([100, 1], 2))
	print(solution([1] * 1000000, 2))