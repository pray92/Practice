
def get_process_count(candidate, times):
	ret = 0
	for time in times:
		ret += candidate // time
	return ret

def solution(n, times):
	max_time = min(times) * n
	candidates = []
	for i in range(1, n + 1):
		for time in times:
			if i * time > max_time:
				break
			candidates.append(i * time)
	candidates.sort()

	answer = 0

	mid = len(candidates) // 2
	left, right = mid, len(candidates)
	while left <= right:
		processed = get_process_count(candidates[mid], times)
		if processed > n:
			right = mid
		elif processed < n:
			left = mid
		else:
			answer = candidates[mid]
			break
		mid = (left + right) // 2


		


	return answer

if __name__ == '__main__':
	print(solution(6, [7, 10]))