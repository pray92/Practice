
def check_valid(rocks, n, k):
	distances = []
	for i in range(1, len(rocks)):
		distances.append(rocks[i] - rocks[i - 1])
	
	cnt = 0
	for i in range(1, len(distances)):
		if distances[i - 1] < k:
			distances[i] += distances[i - 1]
			distances[i - 1] = 0
			cnt += 1
	if distances[-1] < k:
		cnt += 1
	return cnt <= n


def solution(distance, rocks, n):
	rocks.sort()
	rocks.insert(0, 0)
	rocks.append(distance)

	answer = 0

	low, mid, high = 1, 0, distance
	while low < high:
		mid = (low + high) // 2
		if check_valid(rocks, n, mid):
			answer = mid
			low = mid + 1
		else:
			high = mid

	return answer

if __name__ == '__main__':
	print(solution(25, [2, 14, 11, 21, 17], 2))