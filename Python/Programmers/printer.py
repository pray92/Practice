from collections import deque

def solution(priorities, location):

	# 전처리
	prints = deque(enumerate(priorities))

	answer = 0
	
	while True:
		tmp = max(prints, key= lambda x: x[1])
		while max(prints, key= lambda x: x[1]) !=  prints[0]:
			p = prints.popleft()
			prints.append(p)

		printed = prints.popleft()
		answer += 1

		if printed[0] == location:
			break

	return answer

if __name__ == '__main__':
	print(solution([2, 1, 3, 2], 2))
	print(solution([1, 1, 9, 1, 1, 1], 0))