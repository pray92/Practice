
def solution(n, times):
	answer = 0
	
	low, mid, high = 1, 0, max(times) * n
	while low < high:
		mid = (low + high) // 2

		checked = 0
		for time in times:
			checked += mid // time
			
		if checked < n:
			low = mid + 1
		elif checked >= n:
			high = mid
	answer = low
	return answer

if __name__ == '__main__':
	print(solution(7, [3, 3, 3, 2, 10]))