
def min_distance(rocks):
	ret = rocks[0] # 0
	for i in range(0, len(rocks) - 1):
		if ret > (rocks[i + 1] - rocks[i]):
			ret = rocks[i + 1] - rocks[i]
	return ret

def solution(distance, rocks, n):
	rocks.sort()
	rocks.insert(0, 0)
	rocks.append(distance)
	min_distance(rocks)

	answer = 0

	low, mid, high = 1, 0, len(rocks) - 1
	while n > 0 and low < high:
		tmp = []
		mid = (low + high) // 2
		tmp = rocks
		tmp.remove(rocks[mid])


	return answer

if __name__ == '__main__':
	print(solution(25, [2, 14, 11, 21, 17], 2))