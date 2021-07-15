from queue import PriorityQueue

def solution(n, times):
	answer = 0

	q = PriorityQueue()
	goes_on = 1
	while q.qsize() < n:
		for time in times:
			q.put(time * goes_on)
		goes_on += 1


	return q.get()

if __name__ == '__main__':
	print(solution(6, [7, 10]))